package co.edu.iudigital.pos.dtos.producto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Builder // Patrón de diseño
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CompraRequestDTO implements Serializable {

    static final long serialVersionUID = 1L;

    @NotNull(message = "Cantidad requerida")
    Integer cantidad;

}
