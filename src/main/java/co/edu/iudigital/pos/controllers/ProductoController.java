package co.edu.iudigital.pos.controllers;

import co.edu.iudigital.pos.dtos.producto.CompraRequestDTO;
import co.edu.iudigital.pos.dtos.producto.ProductoRequestDTO;
import co.edu.iudigital.pos.dtos.producto.ProductoResponseDTO;
import co.edu.iudigital.pos.exceptions.NotFoundException;
import co.edu.iudigital.pos.services.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // no es buena práctica

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoResponseDTO> save(@Valid @RequestBody ProductoRequestDTO productoRequestDTO) {
        ProductoResponseDTO response = productoService.create(productoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponseDTO>> index() {
        List<ProductoResponseDTO> response = productoService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/buscar-{id}")
    public ResponseEntity<ProductoResponseDTO> getOne(@PathVariable Long id) throws NotFoundException {
        ProductoResponseDTO response = productoService.getById(id);
        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProductoResponseDTO> comprarProducto(
            @Valid @RequestBody CompraRequestDTO compraRequestDTO,
            @PathVariable Long id
    ) {
        Integer cantidad = compraRequestDTO.getCantidad();
        ProductoResponseDTO response = productoService.comprar(id, cantidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
