package co.edu.iudigital.pos.dtos.categoria;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder // Patrón de diseño Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaResponseDTO {

    Long id;

    String nombre;

    String descripcion;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
