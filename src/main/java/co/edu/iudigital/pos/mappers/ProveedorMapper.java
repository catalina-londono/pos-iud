package co.edu.iudigital.pos.mappers;

import co.edu.iudigital.pos.dtos.proveedor.ProveedorRequestDTO;
import co.edu.iudigital.pos.dtos.proveedor.ProveedorResponseDTO;
import co.edu.iudigital.pos.models.Proveedor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProveedorMapper {

    ProveedorMapper INSTANCE = Mappers.getMapper(ProveedorMapper.class);

    Proveedor toProveedor(ProveedorRequestDTO proveedorRequestDTO);

    ProveedorResponseDTO toProveedorResponseDTO(Proveedor proveedor);

    List<ProveedorResponseDTO> toProveedorResponseDTOs(List<Proveedor> proveedors);
}
