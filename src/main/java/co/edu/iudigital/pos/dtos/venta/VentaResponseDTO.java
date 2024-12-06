package co.edu.iudigital.pos.dtos.venta;

import co.edu.iudigital.pos.dtos.productoventa.ProductoVentaRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Builder // Patrón de diseño Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class VentaResponseDTO {

    Long id;

    LocalDateTime fecha;

    Double descuento;

    @JsonProperty("cliente")
    Long cliente;

    @JsonProperty("usuario")
    Long usuario;

    List<ProductoVentaRequestDTO> productosVentas;

    @JsonIgnore
    Double subtotal; // calculable

    @JsonIgnore
    Double total;
}
