package com.proyecto.tienda.service;

import com.proyecto.tienda.dto.VentaClienteDTO;
import com.proyecto.tienda.model.Producto;
import com.proyecto.tienda.model.Venta;
import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    
    public void saveVenta(Venta vent);
    
    public Venta findVenta(Long id);
    
    public List<Venta> getVentas();
    
    public void deleteVentas(Long id);
    
    public void editVenta(Venta vent);
    
    public List<Producto> getProductosde1Venta(Long codigo_venta);
    
    public String ventasDeUnDia(LocalDate fecha_venta);
    
    public VentaClienteDTO mayorVenta();
}
