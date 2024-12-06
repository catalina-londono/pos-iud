package co.edu.iudigital.pos.mappers;

import co.edu.iudigital.pos.dtos.cliente.ClienteRequestDTO;
import co.edu.iudigital.pos.dtos.cliente.ClienteResponseDTO;
import co.edu.iudigital.pos.models.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

    Cliente toCliente(ClienteRequestDTO clienteRequestDTO);

    ClienteResponseDTO toClienteResponseDTO(Cliente cliente);

    List<ClienteResponseDTO> toClienteResponseDTOs (List<Cliente> clientes);
}
