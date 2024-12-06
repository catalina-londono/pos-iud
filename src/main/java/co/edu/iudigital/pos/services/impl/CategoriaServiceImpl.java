package co.edu.iudigital.pos.services.impl;


import co.edu.iudigital.pos.dtos.ErrorDTO;
import co.edu.iudigital.pos.dtos.categoria.CategoriaRequestDTO;
import co.edu.iudigital.pos.dtos.categoria.CategoriaResponseDTO;
import co.edu.iudigital.pos.exceptions.NotFoundException;
import co.edu.iudigital.pos.mappers.CategoriaMapper;
import co.edu.iudigital.pos.models.Categoria;
import co.edu.iudigital.pos.repositories.CategoriaRepository;
import co.edu.iudigital.pos.services.CategoriaService;
import co.edu.iudigital.pos.utils.Constantes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoriaServiceImpl implements CategoriaService {

   @Autowired
    private CategoriaRepository categoriaRepository;

   private final CategoriaMapper categoriaMapper = CategoriaMapper.INSTANCE;

   @Override
   public CategoriaResponseDTO create(CategoriaRequestDTO categoriaRequestDTO) {
       log.info("Llamando al método create desde service");

       Categoria categoria = categoriaMapper.toCategoria(categoriaRequestDTO);
       categoria = categoriaRepository.save(categoria);

       CategoriaResponseDTO categoriaResponseDTO = categoriaMapper.toCategoriaResponseDTO(categoria);

       return categoriaResponseDTO;
   }

   @Override
   public List<CategoriaResponseDTO> getAll() {
      log.info("Llamando al método getAll desde service");
       List<Categoria> categorias = categoriaRepository.findAll();
       List<CategoriaResponseDTO> categoriaResponseDTOS = categoriaMapper.toCategoriaResponseDTOs(categorias);
       return categoriaResponseDTOS;

    }

   @Override
   public CategoriaResponseDTO getById(Long id) throws NotFoundException {
       log.info("Llamando al método getById desde service");
       Categoria categoria = categoriaRepository.findById(id).orElseThrow(
               ()->
                   new NotFoundException(
                           ErrorDTO.getErrorDto(
                                   Constantes.ERROR_CATEGORIA,Constantes.CATEGORIA_NO_EXISTE, HttpStatus.NOT_FOUND.value()
                           )
                   )

       );
       CategoriaResponseDTO categoriaResponseDTO = categoriaMapper.toCategoriaResponseDTO(categoria);
       return categoriaResponseDTO;
    }
}
