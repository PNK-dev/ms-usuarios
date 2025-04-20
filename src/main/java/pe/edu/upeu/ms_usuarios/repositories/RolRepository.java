package pe.edu.upeu.ms_usuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.ms_usuarios.domain.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
