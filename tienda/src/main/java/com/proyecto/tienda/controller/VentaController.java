package com.proyecto.tienda.controller;

import com.proyecto.tienda.dto.VentaClienteDTO;
import com.proyecto.tienda.model.Producto;
import com.proyecto.tienda.model.Venta;
import com.proyecto.tienda.service.VentaService;
import jakarta.websocket.server.PathParam;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    @Autowired
    private VentaService ventServ;
    
    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta vent){
        ventServ.saveVenta(vent);
        return "La venta se ha concluido con exito!";
    }
    
    @GetMapping("/ventas")
    public List<Venta> traerVentas(){
        return ventServ.getVentas();
    }
    
    @GetMapping("/ventas/{codigo_venta}")
    public Venta traerVenta(@PathVariable Long codigo_venta){
        return ventServ.findVenta(codigo_venta);
    }
    
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String eliminarVenta(@PathVariable Long codigo_venta){
        ventServ.deleteVentas(codigo_venta);
        return "La venta se ha eliminado con exito";
    }
    
    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editarVenta(@RequestBody Venta vent){
        ventServ.editVenta(vent);
        return ventServ.findVenta(vent.getCodigo_venta());
    }
    
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> prodctsDe1venta(@PathVariable Long codigo_venta){
        return ventServ.getProductosde1Venta(codigo_venta);
    }
    
    @GetMapping("/ventas/traer/{fecha_venta}")
    public String ventasDia(@PathVariable LocalDate fecha_venta){
        
        return ventServ.ventasDeUnDia(fecha_venta);
    }
    
    @GetMapping("/ventas/mayor_venta")
    public VentaClienteDTO mayorVenta(){
        return ventServ.mayorVenta();
    }
    
}
