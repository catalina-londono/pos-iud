package co.edu.iudigital.pos.services;

import co.edu.iudigital.pos.dtos.venta.VentaRequestDTO;
import co.edu.iudigital.pos.dtos.venta.VentaResponseDTO;
import co.edu.iudigital.pos.exceptions.NotFoundException;
import co.edu.iudigital.pos.models.Venta;

import java.util.List;

public interface VentaService {

    VentaResponseDTO create (VentaRequestDTO ventaRequestDTO) throws NotFoundException;

    List<VentaResponseDTO> getAll();

    VentaResponseDTO getById(Long id) throws NotFoundException;
}
