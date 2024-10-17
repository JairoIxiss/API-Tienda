package com.proyecto.tienda.controller;

import com.proyecto.tienda.model.Cliente;
import com.proyecto.tienda.service.ClienteService;
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
public class ClienteController {
    @Autowired
    private ClienteService cliServ;
    
    @PostMapping("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cli){
        cliServ.saveCliente(cli);
        return "Un nuevo cliente ha sido creado";
    }
    
    @GetMapping("/clientes")
    public List<Cliente> traerClientes(){
        return cliServ.getClientes();
    }
    
    @GetMapping("/clientes/{id_cliente}")
    public Cliente traerCliente(@PathVariable Long id_cliente){
        return cliServ.findCliente(id_cliente);
    }
    
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String eliminarCliente (@PathVariable Long id_cliente){
        cliServ.deleteCliente(id_cliente);
        return "El cliente ha sido eliminado correctamente!";
    }
    
    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editarCliente(@RequestBody Cliente cli){
        cliServ.editCliente(cli);
        return cliServ.findCliente(cli.getId_cliente());
    }
    
}
