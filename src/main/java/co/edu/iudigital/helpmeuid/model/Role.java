package co.edu.iudigital.helpmeuid.model;


import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "roles")
@Data
@FieldDefaults(level = PRIVATE)
public class Role implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name= "nombre", length = 45, nullable = false)
    String nombre;

    String descripcion;

    @ManyToMany(mappedBy = "roles")
    List<Usuario> usuarios;

}
