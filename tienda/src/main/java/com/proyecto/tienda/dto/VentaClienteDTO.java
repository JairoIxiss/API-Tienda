package com.proyecto.tienda.dto;

import com.proyecto.tienda.model.Producto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaClienteDTO {
    
    private Long codigo_venta;
    private Double total;
    private List<Producto> cantidadProductos;
    private String nombreCliente;
    private String apellidoCliente;

    public VentaClienteDTO() {
    }

    public VentaClienteDTO(Long codigo_venta, Double total, List<Producto> cantidadProductos, String nombreCliente, String apellidoCliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cantidadProductos = cantidadProductos;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }


    
}
