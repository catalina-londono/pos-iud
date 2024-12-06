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
@Entity
@Table(name="productos")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Producto implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false, unique = true)
    String nombre;

    @Column(name = "precio_unitario")
    Double precioUnitario;

    @Column()
    Integer stock;

    @Column(name = "created_at", updatable = false)
    LocalDateTime createdAt;

    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "proveedores_id")
    Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "categorias_id")
    Categoria categoria;

    // métodos

    @PrePersist
    public void prePersist() {
        if (stock == null) {
            stock = 0;
        }
            this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void PreUpdate(){
        if(this.updatedAt == null){
            this.updatedAt = LocalDateTime.now();
        }
    }


}
