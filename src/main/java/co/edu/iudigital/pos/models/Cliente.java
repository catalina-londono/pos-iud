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
@Table(name = "clientes")

public class Cliente implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true, nullable = false)
    String identificacion;

    @Column(name = "tipo_identificacion", nullable = false)
    String tipoIdentificacion;

    @Column
    String nombre;

    @Column
    String apellido;

    @Column
    String email;

    @Column
    String telefono;

    @Column
    String calle;

    @Column
    String barrio;

    @Column
    String numero;

    @Column
    String ciudad;

    @Column(name= "created_at", updatable = false)
    LocalDateTime createdAt;

    @Column(name= "updated_at")
    LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "users_id")
    User user;

    // métodos

    @PrePersist
    public void prePersist() {
      this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void PreUpdate(){
        if(this.updatedAt == null){
            this.updatedAt = LocalDateTime.now();
        }
    }

}
