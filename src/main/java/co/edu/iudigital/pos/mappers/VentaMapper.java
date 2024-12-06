package co.edu.iudigital.pos.mappers;

import co.edu.iudigital.pos.dtos.venta.VentaRequestDTO;
import co.edu.iudigital.pos.dtos.venta.VentaResponseDTO;
import co.edu.iudigital.pos.models.Cliente;
import co.edu.iudigital.pos.models.User;
import co.edu.iudigital.pos.models.Venta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VentaMapper {

    VentaMapper INSTANCE = Mappers.getMapper(VentaMapper.class);

    @Mappings({
            @Mapping(source = "cliente", target = "cliente.id"),
            @Mapping(source = "usuario", target = "user.id")
    })
    Venta toVenta(VentaRequestDTO ventaRequestDTO);

    List<VentaResponseDTO> toVentaResponseDTOs(List<Venta> ventas);

    VentaResponseDTO toVentaResponseDTO(Venta venta);

    // Métodos auxiliares para mapear Cliente y User a Long (sus IDs)
    default Long map(Cliente cliente) {
        return cliente != null ? cliente.getId() : null;
    }

    default Long map(User user) {
        return user != null ? user.getId() : null;
    }

    }
