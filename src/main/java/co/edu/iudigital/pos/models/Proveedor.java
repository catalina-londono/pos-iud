package co.edu.iudigital.pos.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.cglib.core.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "proveedores")

public class Proveedor implements Serializable {

    static final long serialVersionUID = 1L;

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(unique = true, nullable = false)
    String nit;

    @Column(nullable = false)
    String nombre;

    @Column
    String direccion;

    @Column
    String telefono;

    @Column(name= "pagina_web", updatable = false)
    String paginaWeb;

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
}