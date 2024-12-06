package co.edu.iudigital.pos.services.impl;

import co.edu.iudigital.pos.dtos.ErrorDTO;
import co.edu.iudigital.pos.dtos.cliente.ClienteRequestDTO;
import co.edu.iudigital.pos.dtos.cliente.ClienteResponseDTO;
import co.edu.iudigital.pos.exceptions.NotFoundException;
import co.edu.iudigital.pos.mappers.ClienteMapper;
import co.edu.iudigital.pos.models.Cliente;
import co.edu.iudigital.pos.repositories.ClienteRepository;
import co.edu.iudigital.pos.services.ClienteService;
import co.edu.iudigital.pos.utils.Constantes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper = ClienteMapper.INSTANCE;

    @Override
    public ClienteResponseDTO create(ClienteRequestDTO clienteRequestDTO) {
        log.info("Llamando al método create desde Service");

        Cliente cliente = clienteMapper.toCliente(clienteRequestDTO);
        cliente = clienteRepository.save(cliente);

        ClienteResponseDTO clienteResponseDTO = clienteMapper.toClienteResponseDTO(cliente);

        return clienteResponseDTO;
    }

    @Override
    public List<ClienteResponseDTO> getAll() {
        log.info("Llamando al método getAll desde service");
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteResponseDTO> clienteResponseDTOS = clienteMapper.toClienteResponseDTOs(clientes);

        return clienteResponseDTOS;
    }

    @Override
    public ClienteResponseDTO getById(Long id) throws NotFoundException {
        log.info("Llamando al método getById desde service");
        Cliente cliente = clienteRepository.findById(id).orElseThrow(
                () ->
                        new NotFoundException(
                                ErrorDTO.getErrorDto(
                                        Constantes.ERROR_CLIENTE, Constantes.CLIENTE_NO_EXISTE, HttpStatus.NOT_FOUND.value()
                                )
                        )
        );
        ClienteResponseDTO clienteResponseDTO = clienteMapper.toClienteResponseDTO(cliente);
        return clienteResponseDTO;
    }
}
