package co.edu.iudigital.pos.controllers;


import co.edu.iudigital.pos.dtos.venta.VentaRequestDTO;
import co.edu.iudigital.pos.dtos.venta.VentaResponseDTO;
import co.edu.iudigital.pos.exceptions.NotFoundException;
import co.edu.iudigital.pos.services.VentaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public ResponseEntity<VentaResponseDTO> save(@Valid @RequestBody VentaRequestDTO ventaRequestDTO) throws NotFoundException {
        VentaResponseDTO response = ventaService.create(ventaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<VentaResponseDTO>> index() {
        List<VentaResponseDTO> response = ventaService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity <VentaResponseDTO> getOne(@PathVariable Long id) throws NotFoundException {
        VentaResponseDTO response = ventaService.getById(id);
        return ResponseEntity.ok().body(response);
        }

    }
