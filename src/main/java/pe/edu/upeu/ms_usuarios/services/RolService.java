package pe.edu.upeu.ms_usuarios.services;

import java.util.List;
import java.util.Optional;
import pe.edu.upeu.ms_usuarios.domain.Rol;
public interface RolService {
    Rol create(Rol rol);
    Rol update(Rol rol);
    void delete(Long id);
    Optional<Rol> read(Long id);
    List<Rol> readAll();
}
