package co.edu.iudigital.pos.dtos.productoventa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Builder // Patrón de diseño
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ProductoVentaRequestDTO implements Serializable {

    static final long serialVersionUID = 1L;

    @JsonProperty("producto_id")
    Long producto;

    @JsonProperty
    Integer cantidad;

    @JsonIgnore
    Long venta; // ventas_id

}
