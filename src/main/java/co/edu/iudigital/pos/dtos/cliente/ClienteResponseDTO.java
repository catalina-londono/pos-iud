package co.edu.iudigital.pos.dtos.cliente;

import co.edu.iudigital.pos.models.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder // Patrón de diseño Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO {

    Long id;

    String identificacion;

    String tipoIdentificacion;

    String nombre;

    String apellido;

    String email;

    String telefono;

    String calle;

    String barrio;

    String numero;

    String ciudad;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
