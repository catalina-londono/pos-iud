package co.edu.iudigital.pos.controllers;


import co.edu.iudigital.pos.dtos.categoria.CategoriaRequestDTO;
import co.edu.iudigital.pos.dtos.categoria.CategoriaResponseDTO;
import co.edu.iudigital.pos.exceptions.NotFoundException;
import co.edu.iudigital.pos.services.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> save(@Valid @RequestBody CategoriaRequestDTO categoriaRequestDTO) {
        CategoriaResponseDTO response =  categoriaService.create(categoriaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> index() {
        List<CategoriaResponseDTO> response = categoriaService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> getOne(@PathVariable Long id) throws NotFoundException {
        CategoriaResponseDTO response = categoriaService.getById(id);
        return ResponseEntity.ok().body(response);
    }


}
