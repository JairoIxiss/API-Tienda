package com.proyecto.tienda.controller;

import com.proyecto.tienda.model.Producto;
import com.proyecto.tienda.service.ProductoService;
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
public class ProductoController {
    @Autowired
    private ProductoService prodServ;
    
    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto prod){
        prodServ.saveProducto(prod);
        return "El producto ha sido creado correctamente!";
    }
    
    @GetMapping("/productos")
    public List<Producto> traerProductos(){
        return prodServ.getProductos();
    }
    
    @GetMapping("/productos/{codigo_producto}")
    public Producto traerProducto(@PathVariable Long codigo_producto){
        return prodServ.findProducto(codigo_producto);
    }
    
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String eliminarProducto(@PathVariable Long codigo_producto){
        prodServ.deleteProducto(codigo_producto);
        return "El producto se ha eliminado correctamente!";
    }
    
    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editarProducto(@RequestBody Producto prod){
        prodServ.editProducto(prod);
        return prodServ.findProducto(prod.getCodigo_producto());
    }
    
    @GetMapping("/productos/falta_stock")
    public List<Producto> faltaStock(){
        return prodServ.faltaProducto();
    }
    
}
