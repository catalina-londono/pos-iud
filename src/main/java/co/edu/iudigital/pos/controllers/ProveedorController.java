package co.edu.iudigital.pos.controllers;

import co.edu.iudigital.pos.dtos.proveedor.ProveedorRequestDTO;
import co.edu.iudigital.pos.dtos.proveedor.ProveedorResponseDTO;
import co.edu.iudigital.pos.exceptions.NotFoundException;
import co.edu.iudigital.pos.services.ProveedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<ProveedorResponseDTO> save (@Valid @RequestBody ProveedorRequestDTO proveedorRequestDTO){
        ProveedorResponseDTO response = proveedorService.create(proveedorRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProveedorResponseDTO>> index() {
        List<ProveedorResponseDTO> response = proveedorService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedorResponseDTO> getOne(@PathVariable Long id) throws NotFoundException {
        ProveedorResponseDTO response = proveedorService.getById(id);
        return ResponseEntity.ok().body(response);
    }
}
