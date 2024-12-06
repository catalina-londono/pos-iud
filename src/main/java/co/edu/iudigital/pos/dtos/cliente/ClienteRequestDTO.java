package co.edu.iudigital.pos.dtos.cliente;

import co.edu.iudigital.pos.models.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Builder // Patrón de diseño
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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
}
