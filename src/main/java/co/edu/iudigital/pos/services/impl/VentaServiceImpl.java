package co.edu.iudigital.pos.services.impl;


import co.edu.iudigital.pos.dtos.ErrorDTO;
import co.edu.iudigital.pos.dtos.productoventa.ProductoVentaRequestDTO;
import co.edu.iudigital.pos.dtos.venta.VentaRequestDTO;
import co.edu.iudigital.pos.dtos.venta.VentaResponseDTO;

import co.edu.iudigital.pos.exceptions.NotFoundException;
import co.edu.iudigital.pos.mappers.ProductoVentaMapper;
import co.edu.iudigital.pos.mappers.VentaMapper;
import co.edu.iudigital.pos.models.Producto;
import co.edu.iudigital.pos.models.ProductoVenta;
import co.edu.iudigital.pos.models.Venta;
import co.edu.iudigital.pos.repositories.ProductoRepository;
import co.edu.iudigital.pos.repositories.ProductoVentaRepository;
import co.edu.iudigital.pos.repositories.VentaRepository;
import co.edu.iudigital.pos.services.VentaService;

import co.edu.iudigital.pos.utils.Constantes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class VentaServiceImpl implements VentaService {

    private final VentaMapper ventaMapper = VentaMapper.INSTANCE;

    private final ProductoVentaMapper productoVentaMapper = ProductoVentaMapper.INSTANCE;

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoVentaRepository productoVentaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Value("${ventas.IVA}")
    private Double IVA;

    @Transactional
    @Override
    public VentaResponseDTO create(VentaRequestDTO ventaRequestDTO)  {

        // Calculo subtotal
        List<ProductoVentaRequestDTO> productosVentas = ventaRequestDTO.getProductosVentas();
        Double subtotal = productosVentas.stream()
                .mapToDouble(pVRDTO -> {
                    Producto producto = productoRepository.findById(pVRDTO.getProducto()).orElseThrow(
                            () -> new RuntimeException("No existe un producto")
                    );
                    return pVRDTO.getCantidad() * producto.getPrecioUnitario();
                })
                .sum();

        ventaRequestDTO.setSubtotal(subtotal);

        //  Calculo total
        Double total = subtotal + (IVA * subtotal) - ventaRequestDTO.getDescuento();
        ventaRequestDTO.setTotal(total);
        Venta venta = ventaMapper.toVenta(ventaRequestDTO);

        // Guardamos en ventas
        venta = ventaRepository.save(venta);
        final Long ventaId = venta.getId();

        // guardamos en productos_ventas

            List<ProductoVentaRequestDTO> ventaRequestDTOS =
                ventaRequestDTO.getProductosVentas().stream()
                        .map(productoVentaRequestDTO -> {
                            ProductoVentaRequestDTO productoVenta =
                                    ProductoVentaRequestDTO
                                            .builder()
                                            .cantidad(productoVentaRequestDTO.getCantidad())
                                            .producto(productoVentaRequestDTO.getProducto())
                                            .venta(ventaId)
                                            .build();
                            return productoVenta;
                        })
                        .collect(Collectors.toList());

        List<ProductoVenta> productoVentas =
                productoVentaMapper.toProductoVentaList(ventaRequestDTOS);

        productoVentas = productoVentaRepository.saveAll(productoVentas);

        // construimos VentaResponseDTO
        VentaResponseDTO ventaResponseDTO =
                VentaResponseDTO.builder()
                        .id(ventaId)
                        .descuento(venta.getDescuento())
                        .cliente(venta.getCliente().getId())
                        .usuario(venta.getUser().getId())
                        .build();

        return ventaResponseDTO;
    }

    @Override
    public List<VentaResponseDTO> getAll() {
        log.info("llamando el método getAll desde service");
        List<Venta> ventas = ventaRepository.findAll();
        List<VentaResponseDTO> ventaResponseDTOS = ventaMapper.toVentaResponseDTOs(ventas);
        return ventaResponseDTOS;
    }

    @Override
    public VentaResponseDTO getById(Long id) throws NotFoundException {
        log.info("Llamando al método getById desde service");
        Venta venta = ventaRepository.findById(id).orElseThrow(
                ()->
                        new NotFoundException(
                                ErrorDTO.getErrorDto(
                                        Constantes.ERROR_VENTA, Constantes.VENTA_NO_EXISTE, HttpStatus.NOT_FOUND.value()
                                )
                        )
        );
        VentaResponseDTO ventaResponseDTO = ventaMapper.toVentaResponseDTO(venta);
        return ventaResponseDTO;
    }
}
