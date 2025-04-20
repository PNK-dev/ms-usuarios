package pe.edu.upeu.ms_usuarios.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.ms_usuarios.domain.Privilegio;
import pe.edu.upeu.ms_usuarios.repositories.PrivilegioRepository;
import pe.edu.upeu.ms_usuarios.services.PrivilegioService;

import java.util.List;
import java.util.Optional;

@Service
public class PrivilegioServiceImpl implements PrivilegioService {
    @Autowired
    private PrivilegioRepository privilegioRepository;
    public PrivilegioServiceImpl(PrivilegioRepository privilegioRepository) {
        this.privilegioRepository = privilegioRepository;
    }
    @Override
    public Privilegio create(Privilegio privilegio) {
        return privilegioRepository.save(privilegio);
    }

    @Override
    public Privilegio update(Privilegio privilegio) {
        return privilegioRepository.save(privilegio);
    }

    @Override
    public void delete(Long id) {
        privilegioRepository.deleteById(id);
    }

    @Override
    public Optional<Privilegio> read(Long id) {
        return privilegioRepository.findById(id);
    }

    @Override
    public List<Privilegio> readAll() {
        return privilegioRepository.findAll();
    }
}
