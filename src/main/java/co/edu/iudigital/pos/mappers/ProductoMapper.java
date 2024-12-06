package co.edu.iudigital.pos.mappers;

import co.edu.iudigital.pos.dtos.producto.ProductoRequestDTO;
import co.edu.iudigital.pos.dtos.producto.ProductoResponseDTO;
import co.edu.iudigital.pos.models.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductoMapper {

    ProductoMapper INSTANCE = Mappers.getMapper(ProductoMapper.class);

    @Mappings({
            @Mapping(source = "proveedor", target = "proveedor.id"),
            @Mapping(source = "categoria", target = "categoria.id")
    })
    Producto toProducto(ProductoRequestDTO productoRequestDTO);

    @Mappings({
            @Mapping(source = "proveedor.nombre", target = "proveedor"),
            })
    ProductoResponseDTO toProductoResponseDTO(Producto producto);

    List<ProductoResponseDTO> toProductoResponseDTOs(List<Producto> productos);

}
