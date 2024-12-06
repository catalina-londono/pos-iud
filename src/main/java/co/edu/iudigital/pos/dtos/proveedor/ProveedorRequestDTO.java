package co.edu.iudigital.pos.dtos.proveedor;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder // Patrón de diseño
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorRequestDTO implements Serializable {

    static final long SerialVersionUID = 1L;

    String nit;

    @NotNull(message = "Nombre requerido")
    String nombre;

    String direccion;

    String telefono;

    String paginaWeb;

}
