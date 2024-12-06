package co.edu.iudigital.pos.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "productos_ventas")
public class ProductoVenta {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name = "productos_id")
    Producto producto;

    @ManyToOne
    @JoinColumn(name = "ventas_id")
    Venta venta;

    @Column (nullable = false)
    Integer cantidad;

}
