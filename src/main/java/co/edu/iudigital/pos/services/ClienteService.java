package co.edu.iudigital.pos.services;

import co.edu.iudigital.pos.dtos.cliente.ClienteRequestDTO;
import co.edu.iudigital.pos.dtos.cliente.ClienteResponseDTO;
import co.edu.iudigital.pos.exceptions.NotFoundException;

import java.util.List;

public interface ClienteService {

    ClienteResponseDTO create(ClienteRequestDTO clienteRequestDTO);

    List<ClienteResponseDTO> getAll();

    ClienteResponseDTO getById(Long id) throws NotFoundException;

}
