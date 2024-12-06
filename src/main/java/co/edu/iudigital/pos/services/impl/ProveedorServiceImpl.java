package co.edu.iudigital.pos.services.impl;

import co.edu.iudigital.pos.dtos.ErrorDTO;
import co.edu.iudigital.pos.dtos.proveedor.ProveedorRequestDTO;
import co.edu.iudigital.pos.dtos.proveedor.ProveedorResponseDTO;
import co.edu.iudigital.pos.exceptions.NotFoundException;
import co.edu.iudigital.pos.mappers.ProveedorMapper;
import co.edu.iudigital.pos.models.Proveedor;
import co.edu.iudigital.pos.repositories.ProveedorRepository;
import co.edu.iudigital.pos.services.ProveedorService;
import co.edu.iudigital.pos.utils.Constantes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    private final ProveedorMapper proveedorMapper = ProveedorMapper.INSTANCE;

    @Override
    public ProveedorResponseDTO create(ProveedorRequestDTO proveedorRequestDTO) {
        log.info("Llamando al método create desde service");

        Proveedor proveedor = proveedorMapper.toProveedor(proveedorRequestDTO);
        proveedor = proveedorRepository.save(proveedor);

        ProveedorResponseDTO proveedorResponseDTO = proveedorMapper.toProveedorResponseDTO(proveedor);

        return proveedorResponseDTO;
    }

    @Override
    public List<ProveedorResponseDTO> getAll() {
        log.info("Llamando al método getAll desde service");
        List<Proveedor> proveedors = proveedorRepository.findAll();
        List<ProveedorResponseDTO> proveedorResponseDTOS = proveedorMapper.toProveedorResponseDTOs(proveedors);
        return proveedorResponseDTOS;
    }

    @Override
    public ProveedorResponseDTO getById(Long id) throws NotFoundException {
        log.info("llamando al método getById desde service");
        Proveedor proveedor = proveedorRepository.findById(id).orElseThrow(
                ()->
                        new NotFoundException(
                                ErrorDTO.getErrorDto(
                                        Constantes.ERROR_PROVEEDOR,Constantes.PROVEEDOR_NO_EXISTE, HttpStatus.NOT_FOUND.value()
                                )
                        )
        );
        ProveedorResponseDTO proveedorResponseDTO = proveedorMapper.toProveedorResponseDTO(proveedor);
        return proveedorResponseDTO;
    }
}
