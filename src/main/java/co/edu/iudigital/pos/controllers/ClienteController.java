package co.edu.iudigital.pos.controllers;

import co.edu.iudigital.pos.dtos.cliente.ClienteRequestDTO;
import co.edu.iudigital.pos.dtos.cliente.ClienteResponseDTO;
import co.edu.iudigital.pos.exceptions.NotFoundException;
import co.edu.iudigital.pos.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity <ClienteResponseDTO> save (@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO response = clienteService.create(clienteRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> index() {
        List<ClienteResponseDTO> response = clienteService.getAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getOne(@PathVariable Long id) throws NotFoundException {
        ClienteResponseDTO response = clienteService.getById(id);
        return ResponseEntity.ok().body(response);
    }
}
