package com.proyecto.tienda.service;

import com.proyecto.tienda.model.Producto;
import java.util.List;

public interface IProductoService {
    
    public void saveProducto(Producto prod);
    
    public Producto findProducto(Long id);
    
    public List<Producto> getProductos();
    
    public void deleteProducto(Long id);
    
    public void editProducto(Producto prod);
    
    public List<Producto> faltaProducto();
    
}
