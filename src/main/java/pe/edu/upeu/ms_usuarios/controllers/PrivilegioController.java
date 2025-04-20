package pe.edu.upeu.ms_usuarios.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upeu.ms_usuarios.domain.Privilegio;
import pe.edu.upeu.ms_usuarios.services.PrivilegioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/privilegios")
@CrossOrigin(origins = "http://localhost:4200")
public class PrivilegioController {
    @Autowired
    private PrivilegioService privilegioService;

    @GetMapping
    public ResponseEntity<List<Privilegio>> readAll() {
        try {
            List<Privilegio> privilegios = privilegioService.readAll();
            if (privilegios.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(privilegios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Privilegio> crear(@Valid @RequestBody Privilegio privilegio) {
        try {
            Privilegio c = privilegioService.create(privilegio);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Privilegio> getPrivilegioId(@PathVariable("id") Long id) {
        try {
            Optional<Privilegio> p = privilegioService.read(id);
            return p.map(privilegio -> new ResponseEntity<>(privilegio, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delPrivilegio(@PathVariable("id") Long id) {
        try {
            privilegioService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Privilegio> updatePrivilegio(@PathVariable("id") Long id, @Valid @RequestBody Privilegio privilegio) {
        Optional<Privilegio> p = privilegioService.read(id);
        if (p.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(privilegioService.update(privilegio), HttpStatus.OK);
        }
    }
}
