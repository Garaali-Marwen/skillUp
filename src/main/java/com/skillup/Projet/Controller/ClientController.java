package com.Projet.Projet.Controller;

import com.Projet.Projet.Entities.Client;
import com.Projet.Projet.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id") Long clientId) {
        return clientService.getClientById(clientId);
    }
    @PostMapping("/add")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }
    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client) {
        return clientService.updateClient(client);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable("id") Long clientId) {
        clientService.deleteClient(clientId);
    }
    @GetMapping("/formation/{fid}/client/{cid}")
    public Client addClientToFormation(@PathVariable("cid") Long clientId, @PathVariable("fid") Long formationId) {
        return clientService.addClientToFormation(clientId, formationId);
    }

}
