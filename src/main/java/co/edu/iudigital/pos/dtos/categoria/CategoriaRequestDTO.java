package co.edu.iudigital.pos.dtos.categoria;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Builder // Patrón de diseño
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "Nombre requerido")
    String nombre;

    String descripcion;
}
