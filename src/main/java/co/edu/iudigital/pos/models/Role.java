package co.edu.iudigital.pos.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "roles")

public class Role implements Serializable {

    static final long serialVersionUID = 1L;

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column (unique = true, nullable = false)
    String nombre;

    @Column
    String descripcion;

    @Column(name= "created_at", updatable = false)
    LocalDateTime createdAt;

    @Column(name= "updated_at")
    LocalDateTime updatedAt;

    // métodos

    @PrePersist
    public void prePersist() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void PreUpdate(){
        if(this.updatedAt == null){
            this.updatedAt = LocalDateTime.now();
        }
    }

    /* @ManyToMany // es opcional, aunque se recomienda no incluirla debido a que implica "complicarse más"
    List<User> users; */

}
