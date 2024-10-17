package com.proyecto.tienda.service;

import com.proyecto.tienda.model.Cliente;
import com.proyecto.tienda.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteRepository cliRepo;
    
    @Override
    public void saveCliente(Cliente cli) {

        cliRepo.save(cli);

    }

    @Override
    public Cliente findCliente(Long id) {

        return cliRepo.findById(id).orElse(null);
        
    }

    @Override
    public List<Cliente> getClientes() {

        return cliRepo.findAll();

    }

    @Override
    public void deleteCliente(Long id) {

        cliRepo.deleteById(id);

    }

    @Override
    public void editCliente(Cliente cli) {

        this.saveCliente(cli);

    }
    
}
