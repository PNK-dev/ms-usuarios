package pe.edu.upeu.ms_usuarios.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="nombres")
    private String nombres;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="email")
    private String email;
    @Column(name="contrasenia")
    private String contrasenia;
    @Column(name = "fechainicio")
    private Date fechainicio;
    @Column(name = "fechaupdate")
    private Date fechaupdate;
    @Column(name = "estado")
    private boolean estado;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private Set<Rol> roles = new HashSet<>();
}
