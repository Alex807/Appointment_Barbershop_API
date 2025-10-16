package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.dto.Client;
import com.AlexBurada.Barbershop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping //can stay with base mapping(mentioned above controller)
    public List<Client> getClients() {
        return service.getClients();
    }

    @GetMapping("/{clientId}")
    public Client getClientById(@PathVariable int clientId) {
        return service.getClientById(clientId);
    }

    @PostMapping
    public void addClient(@RequestBody Client client) {
        service.addClient(client);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<String> updateClient(@PathVariable int clientId, @RequestBody Client client) {
        service.updateClient(client);
    }
}
