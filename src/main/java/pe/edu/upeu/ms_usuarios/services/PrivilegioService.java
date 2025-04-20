package pe.edu.upeu.ms_usuarios.services;

import pe.edu.upeu.ms_usuarios.domain.Privilegio;

import java.util.List;
import java.util.Optional;
public interface PrivilegioService {
    Privilegio create(Privilegio privilegio);
    Privilegio update(Privilegio privilegio);
    void delete(Long id);
    Optional<Privilegio> read(Long id);
    List<Privilegio> readAll();
}
