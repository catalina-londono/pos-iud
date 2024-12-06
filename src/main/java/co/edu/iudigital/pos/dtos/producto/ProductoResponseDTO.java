package co.edu.iudigital.pos.dtos.producto;


import co.edu.iudigital.pos.dtos.categoria.CategoriaResponseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder // Patrón de diseño Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ProductoResponseDTO {

    Long id;

    String nombre;

    @JsonProperty("precio_unitario")
    Double precioUnitario;

    Integer stock;

    @JsonProperty("created_at")
    LocalDateTime createdAt;

    @JsonProperty("updated_at")
    LocalDateTime updatedAt;

    @JsonProperty("nombre_proveedor")
    String proveedor;

    CategoriaResponseDTO categoria;
}
