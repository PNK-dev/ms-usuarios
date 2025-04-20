package pe.edu.upeu.ms_usuarios.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.ms_usuarios.domain.Rol;
import pe.edu.upeu.ms_usuarios.repositories.RolRepository;
import pe.edu.upeu.ms_usuarios.services.RolService;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    private RolRepository rolRepository;
    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
    @Override
    public Rol create(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol update(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void delete(Long id) {
        rolRepository.deleteById(id);
    }

    @Override
    public Optional<Rol> read(Long id) {
        return rolRepository.findById(id);
    }

    @Override
    public List<Rol> readAll() {
        return rolRepository.findAll();
    }
}
