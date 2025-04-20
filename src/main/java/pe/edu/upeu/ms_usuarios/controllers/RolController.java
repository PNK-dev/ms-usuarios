package pe.edu.upeu.ms_usuarios.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.ms_usuarios.domain.Rol;
import pe.edu.upeu.ms_usuarios.services.RolService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/roles")
@CrossOrigin(origins = "http://localhost:4200")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> readAll() {
        try {
            List<Rol> roles = rolService.readAll();
            if (roles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(roles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Rol> crear(@Valid @RequestBody Rol rol) {
        try {
            Rol r = rolService.create(rol);
            return new ResponseEntity<>(r, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolId(@PathVariable("id") Long id) {
        try {
            Optional<Rol> r = rolService.read(id);
            return r.map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delRol(@PathVariable("id") Long id) {
        try {
            rolService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable("id") Long id, @Valid @RequestBody Rol rol) {
        Optional<Rol> r = rolService.read(id);
        if (r.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(rolService.update(rol), HttpStatus.OK);
        }
    }
}
