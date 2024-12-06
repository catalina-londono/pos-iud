package co.edu.iudigital.pos.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")

public class User implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true, nullable = false)
    String username;

    @Column(nullable = false)
    String password;

    @Column
    String nombre;

    @Column
    String apellido;

    @Column(name = "fecha_nacimiento")
    Date fechaNacimiento;

    @Column
    String foto;

    @Column(name= "created_at", updatable = false)
    LocalDateTime createdAt;

    @Column(name= "updated_at")
    LocalDateTime updatedAt;

    @Column(nullable = false)
    Boolean enabled;

    @PrePersist
    public void prePersist() {
        if (enabled == null) {
            enabled = true;
        }
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void PreUpdate(){
        if(this.updatedAt == null){
            this.updatedAt = LocalDateTime.now();
        }
    }

   @ManyToMany
   @JoinTable(
           name = "roles_usuarios",
           joinColumns = {@JoinColumn(name = "users_id")},
           inverseJoinColumns ={@JoinColumn(name = "roles_id")},
           uniqueConstraints = {@UniqueConstraint(columnNames = {"users_id", "roles_id"})}
   )
   List<Role> roles;

}
