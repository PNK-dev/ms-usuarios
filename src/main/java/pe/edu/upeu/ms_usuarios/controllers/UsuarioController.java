package pe.edu.upeu.ms_usuarios.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.ms_usuarios.domain.Usuario;
import pe.edu.upeu.ms_usuarios.services.UsuarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> readAll() {
        try {
            List<Usuario> usuarios = usuarioService.readAll();
            if (usuarios.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@Valid @RequestBody Usuario usuario) {
        try {
            Usuario u = usuarioService.create(usuario);
            return new ResponseEntity<>(u, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioId(@PathVariable("id") Long id) {
        try {
            Optional<Usuario> u = usuarioService.read(id);
            return u.map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delUsuario(@PathVariable("id") Long id) {
        try {
            usuarioService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") Long id, @Valid @RequestBody Usuario usuario) {
        Optional<Usuario> u = usuarioService.read(id);
        if (u.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(usuarioService.update(usuario), HttpStatus.OK);
        }
    }
}
