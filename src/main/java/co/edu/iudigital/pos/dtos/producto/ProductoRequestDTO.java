package co.edu.iudigital.pos.dtos.producto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;


@Builder // Patrón de diseño
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor

public class ProductoRequestDTO implements Serializable {

    static final long serialVersionUID = 1L;

    @NotNull(message = "Nombre de producto requerido")
    String nombre;

    @NotNull
    @JsonProperty("precio_unitario")
    Double precioUnitario;

    @Min(value = 0, message = "Formato inválido Stock")
    Integer stock;

    @JsonProperty("proveedor_id")
    Long proveedor;

    @JsonProperty("categoria_id")
    Long categoria;
}
