package co.edu.iudigital.pos.dtos.venta;

import co.edu.iudigital.pos.dtos.productoventa.ProductoVentaRequestDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Builder // Patrón de diseño
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class VentaRequestDTO implements Serializable {

    static final long serialVersionUID = 1L;

    LocalDateTime fecha;

    Double descuento;

    @JsonProperty("clientes_id")
    Long cliente;

    @JsonProperty("usuarios_id")
    Long usuario;

    List<ProductoVentaRequestDTO> productosVentas;

    @JsonIgnore
    Double subtotal; // calculable

    @JsonIgnore
    Double total; // calculable
}
