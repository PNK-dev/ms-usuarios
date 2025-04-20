package pe.edu.upeu.ms_usuarios.services;
import pe.edu.upeu.ms_usuarios.domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario create(Usuario usuario);
    Usuario update(Usuario usuario);
    void delete(Long id);
    Optional<Usuario> read(Long id);
    List<Usuario> readAll();
}
