package com.proyecto.tienda.service;

import com.proyecto.tienda.model.Producto;
import com.proyecto.tienda.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository prodRepo;
    
    @Override
    public void saveProducto(Producto prod) {

        prodRepo.save(prod);

    }

    @Override
    public Producto findProducto(Long id) {

        return prodRepo.findById(id).orElse(null);

    }

    @Override
    public List<Producto> getProductos() {

        return prodRepo.findAll();
        
    }

    @Override
    public void deleteProducto(Long id) {

        prodRepo.deleteById(id);

    }

    @Override
    public void editProducto(Producto prod) {

        this.saveProducto(prod);

    }

    @Override
    public List<Producto> faltaProducto() {

        List<Producto> listaFaltan = new ArrayList<>();
        List<Producto> listaStock = this.getProductos();
        
        for (Producto producto : listaStock) {
            Producto prod = producto;
            Double stock = prod.getStock_disponible();
            if(stock<5.0){
                listaFaltan.add(prod);
            }
        }
        return listaFaltan;
    }
    
}
