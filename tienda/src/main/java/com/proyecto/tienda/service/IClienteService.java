package com.proyecto.tienda.service;

import com.proyecto.tienda.model.Cliente;
import java.util.List;

public interface IClienteService {
    
    public void saveCliente(Cliente cli);
    
    public Cliente findCliente(Long id);
    
    public List<Cliente> getClientes();
    
    public void deleteCliente(Long id);
    
    public void editCliente(Cliente cli);
    
}
