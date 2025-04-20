package pe.edu.upeu.ms_usuarios.services.impl;

import org.springframework.stereotype.Service;
import pe.edu.upeu.ms_usuarios.domain.Usuario;
import pe.edu.upeu.ms_usuarios.repositories.UsuarioRepository;
import pe.edu.upeu.ms_usuarios.services.UsuarioService;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioRepository usuarioRepository;
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> read(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> readAll() {
        return usuarioRepository.findAll();
    }
}
