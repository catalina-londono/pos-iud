package co.edu.iudigital.pos.services.impl;

import co.edu.iudigital.pos.dtos.ErrorDTO;
import co.edu.iudigital.pos.dtos.producto.ProductoRequestDTO;
import co.edu.iudigital.pos.dtos.producto.ProductoResponseDTO;
import co.edu.iudigital.pos.exceptions.NotFoundException;
import co.edu.iudigital.pos.mappers.ProductoMapper;
import co.edu.iudigital.pos.models.Producto;
import co.edu.iudigital.pos.repositories.ProductoRepository;
import co.edu.iudigital.pos.services.ProductoService;
import co.edu.iudigital.pos.utils.Constantes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    private final ProductoMapper productoMapper = ProductoMapper.INSTANCE;

    @Override
    public ProductoResponseDTO create(ProductoRequestDTO productoRequestDTO) {
        Producto producto = productoMapper.toProducto(productoRequestDTO);
        producto = productoRepository.save(producto);
        ProductoResponseDTO productoResponseDTO = productoMapper.toProductoResponseDTO(producto);
        return productoResponseDTO;
    }

    @Override
    public List<ProductoResponseDTO> getAll() {
        log.info("Llamando al método getAll desde service");
        List<Producto> productos = productoRepository.findAll();
        List<ProductoResponseDTO> productoResponseDTOS = productoMapper.toProductoResponseDTOs(productos);
        return productoResponseDTOS;
    }

    @Override
    public ProductoResponseDTO getById(Long id) throws NotFoundException {
        log.info("LLamando el método getById desde service");
        Producto producto = productoRepository.findById(id).orElseThrow(
                ()->
                        new NotFoundException(
                                ErrorDTO.getErrorDto(
                                        Constantes.ERROR_PRODUCTO, Constantes.PRODUCTO_NO_EXISTE, HttpStatus.NOT_FOUND.value()
                                )
                        )
        );
        ProductoResponseDTO productoResponseDTO = productoMapper.toProductoResponseDTO(producto);
        return productoResponseDTO;
    }

    @Override
    public ProductoResponseDTO comprar(Long id, Integer cantidad) {
        // select stock from productos where id=id
        // update productos set stock = stock + cantidad where id = id
        Producto producto = productoRepository.findById(id).orElseThrow(()->
                new RuntimeException("No existe producto")
        );
        Integer stock = producto.getStock();
        stock = stock + cantidad;
        producto.setStock(stock);
        producto = productoRepository.save(producto);
        ProductoResponseDTO productoResponseDTO = productoMapper.toProductoResponseDTO(producto);
        return productoResponseDTO;
    }
}
