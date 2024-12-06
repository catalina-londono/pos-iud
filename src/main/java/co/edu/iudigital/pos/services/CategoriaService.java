package co.edu.iudigital.pos.services;

import co.edu.iudigital.pos.dtos.categoria.CategoriaRequestDTO;
import co.edu.iudigital.pos.dtos.categoria.CategoriaResponseDTO;
import co.edu.iudigital.pos.exceptions.NotFoundException;

import java.util.List;

public interface CategoriaService {

    CategoriaResponseDTO create(CategoriaRequestDTO categoriaRequestDTO);

    List<CategoriaResponseDTO> getAll();

    CategoriaResponseDTO getById(Long id) throws NotFoundException;


}
