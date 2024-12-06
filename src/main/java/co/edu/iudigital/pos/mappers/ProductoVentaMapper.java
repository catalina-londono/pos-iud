package co.edu.iudigital.pos.mappers;

import co.edu.iudigital.pos.dtos.productoventa.ProductoVentaRequestDTO;
import co.edu.iudigital.pos.models.ProductoVenta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductoVentaMapper {

    ProductoVentaMapper INSTANCE = Mappers.getMapper(ProductoVentaMapper.class);

    @Mappings({
            @Mapping(source = "producto", target = "producto.id"),
            @Mapping(source = "venta", target = "venta.id")
    })
    ProductoVenta toProductoVenta(ProductoVentaRequestDTO productoVentaRequestDTO);

    List<ProductoVenta> toProductoVentaList(List<ProductoVentaRequestDTO> productoVentaRequestDTOS);

    // Métodos inversos (opcional)
    @Mappings({
            @Mapping(source = "producto.id", target = "producto"),
            @Mapping(source = "venta.id", target = "venta")
    })
    ProductoVentaRequestDTO toProductoVentaRequestDTO(ProductoVenta productoVenta);

    List<ProductoVentaRequestDTO> toProductoVentaRequestDTOList(List<ProductoVenta> productoVentas);

}
