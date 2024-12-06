package co.edu.iudigital.pos.services;

import co.edu.iudigital.pos.dtos.proveedor.ProveedorRequestDTO;
import co.edu.iudigital.pos.dtos.proveedor.ProveedorResponseDTO;
import co.edu.iudigital.pos.exceptions.NotFoundException;

import java.util.List;

public interface ProveedorService {

    ProveedorResponseDTO create(ProveedorRequestDTO proveedorRequestDTO);

    List<ProveedorResponseDTO> getAll();

    ProveedorResponseDTO getById(Long id) throws NotFoundException;
}
