package co.edu.iudigital.pos.mappers;

import co.edu.iudigital.pos.dtos.categoria.CategoriaRequestDTO;
import co.edu.iudigital.pos.dtos.categoria.CategoriaResponseDTO;
import co.edu.iudigital.pos.models.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    Categoria toCategoria(CategoriaRequestDTO categoriaRequestDTO);

    CategoriaResponseDTO toCategoriaResponseDTO(Categoria categoria);

    List<CategoriaResponseDTO> toCategoriaResponseDTOs(List<Categoria> categorias);

    /*static Categoria toCategoria(CategoriaRequestDTO categoriaRequestDTO){
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaRequestDTO.getNombre());
        categoria.setDescripcion(categoriaRequestDTO.getDescripcion());
        return categoria;
    }

    static CategoriaResponseDTO toCategoriaResponseDTO(Categoria categoria) {
       return CategoriaResponseDTO.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .createdAt(categoria.getCreatedAt())
                .updatedAt(categoria.getUpdatedAt())
                .build();
    }*/
}
