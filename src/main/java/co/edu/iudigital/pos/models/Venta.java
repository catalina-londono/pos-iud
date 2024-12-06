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
@Table(name = "ventas")

public class Venta implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    LocalDateTime fecha;

    @Column
    Double descuento;

    @Column
    Double subtotal;

    @Column
    Double total;

    @Column
    String estado;

    @Column(name= "updated_at")
    LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "clientes_id")
    Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "users_id")
    User user;

    // métodos

    @PrePersist
    public void prePersist() {
        if (fecha == null) { // Asegúrate de que solo se asigne si está nulo
            fecha = LocalDateTime.now();
        }
        if (descuento == null) {
            descuento = 0.0;
        }
        if (estado == null) {
            estado = "OK";
        }
    }

    @PreUpdate
    public void PreUpdate(){
        if(this.updatedAt == null){
            this.updatedAt = LocalDateTime.now();
        }
    }
}
