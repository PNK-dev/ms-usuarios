package pe.edu.upeu.ms_usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.ms_usuarios.domain.Privilegio;

@Repository
public interface PrivilegioRepository extends JpaRepository<Privilegio, Long> {
}
