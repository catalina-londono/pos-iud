package co.edu.iudigital.pos.services;

import co.edu.iudigital.pos.dtos.producto.ProductoRequestDTO;
import co.edu.iudigital.pos.dtos.producto.ProductoResponseDTO;
import co.edu.iudigital.pos.exceptions.NotFoundException;

import java.util.List;

public interface ProductoService {

    ProductoResponseDTO create(ProductoRequestDTO productoRequestDTO);

    List<ProductoResponseDTO> getAll();

    ProductoResponseDTO getById(Long id) throws NotFoundException;

    ProductoResponseDTO comprar(Long id, Integer cantidad);

}
