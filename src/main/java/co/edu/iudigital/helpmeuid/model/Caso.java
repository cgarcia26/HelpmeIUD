package co.edu.iudigital.helpmeuid.model;


import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "casos")
@Data
@FieldDefaults(level = PRIVATE)
public class Caso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "fecha_hora", nullable = false)
    LocalDateTime fechaHora;

    @Column
    Float latitud;

    @Column
    Float longitud;

    @Column
    Float altitud;

    @Column
    Boolean visible;

    @Column(name = "descripcion", length = 200)
    String descripcion;

    @Column(name = "url_map")
    String urlMap;

    @Column(name = "rmi_url")
    String rmiUrl;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delitos_id")
    Delito delito;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuarios_id")
    Usuario usuario;


    @PrePersist
    public void prePersist() {
        if(Objects.isNull(fechaHora)) {
            fechaHora = LocalDateTime.now();
        }
    }

}
