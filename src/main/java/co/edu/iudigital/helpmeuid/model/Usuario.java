package co.edu.iudigital.helpmeuid.model;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "usuarios")
@Data
@FieldDefaults(level = PRIVATE)
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "username", length = 120, nullable = false, unique = true)
    String username;

    @Column(name = "nombre", length = 120, nullable = false)
    String nombre;


    @Column(name = "apellido", length = 120)
    String apellido;

    @Column
    String password;


    @Column(name = "fecha_nacimiento")
    LocalDate fechaNacimiento;

    @Column
    Boolean enabled;

    @Column(name = "red_social")
    Boolean redSocial;

    @Column
    String image;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.REMOVE,
                    CascadeType.REFRESH
            })
    @JoinTable(name = "roles_usuarios",
            joinColumns = {
                    @JoinColumn(name = "usuarios_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "roles_id")
            })
    List<Role> roles;

    @PrePersist
    void persist() {
        if (enabled == null) {
            enabled = true;
        }
        if (redSocial == null) {
            redSocial = false;
        }
    }

}
