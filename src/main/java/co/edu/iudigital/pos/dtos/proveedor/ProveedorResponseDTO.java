package co.edu.iudigital.pos.dtos.proveedor;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder // Patrón de diseño Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorResponseDTO {

    Long id;

    String nit;

    String nombre;

    String direccion;

    String telefono;

    String paginaWeb;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
