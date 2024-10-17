package com.proyecto.tienda.service;

import com.proyecto.tienda.dto.VentaClienteDTO;
import com.proyecto.tienda.model.Producto;
import com.proyecto.tienda.model.Venta;
import com.proyecto.tienda.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{
    @Autowired
    private IVentaRepository ventRepo;
    
    @Override
    public void saveVenta(Venta vent) {
        
        ventRepo.save(vent);
        
    }

    @Override
    public Venta findVenta(Long id) {

        return ventRepo.findById(id).orElse(null);

    }

    @Override
    public List<Venta> getVentas() {
        
        return ventRepo.findAll();
        
    }

    @Override
    public void deleteVentas(Long id) {

        ventRepo.deleteById(id);

    }

    @Override
    public void editVenta(Venta vent) {

        this.saveVenta(vent);
       
    }

    @Override
    public List<Producto> getProductosde1Venta(Long codigo_venta) {

        Venta venta =this.findVenta(codigo_venta);
        return venta.getListaProductos();

    }

    @Override
    public String ventasDeUnDia(LocalDate fecha_venta) {
        LocalDate fechaBusc;
        
        Double monto = 0.0;
        int cantidad = 0;
        
        List<Venta> listVent = this.getVentas();
        for (Venta venta : listVent) {
            fechaBusc = venta.getFecha_venta();
            if(fechaBusc.isEqual(fecha_venta)){
                monto= monto + venta.getTotal();
                cantidad++;
            }
        }
        return "La cantidad de ventas la fecha " +fecha_venta+ " es de " +cantidad+ ", y el monto total de $" +monto;
    }

    @Override
    public VentaClienteDTO mayorVenta() {

        Double total;
        Double totalcomp;
        Long idMayor=0L;
        List<Venta> listVentas = this.getVentas();
        VentaClienteDTO ventClient = new VentaClienteDTO();
        
        
        for (Venta venta : listVentas) {
            total = venta.getTotal();
            
            for (Venta ventcomp : listVentas) {
                totalcomp = ventcomp.getTotal();
                if(totalcomp>total){
                    idMayor = ventcomp.getCodigo_venta();
                }
            }            
        }
        
        Venta ventMay = this.findVenta(idMayor);
        ventClient.setCodigo_venta(ventMay.getCodigo_venta());
        ventClient.setCantidadProductos(ventMay.getListaProductos());
        ventClient.setNombreCliente(ventMay.getUnCliente().getNombre());
        ventClient.setApellidoCliente(ventMay.getUnCliente().getApellido());
        ventClient.setTotal(ventMay.getTotal());
        
        return ventClient;
    }
}
