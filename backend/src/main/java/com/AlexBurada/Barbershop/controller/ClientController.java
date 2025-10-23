package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.dto.ClientDTO;
import com.AlexBurada.Barbershop.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(final ClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients() {

        return new ResponseEntity<>(service.getClients(), HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable int clientId) {

        return new ResponseEntity<>(service.getClientById(clientId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@Valid @RequestBody ClientDTO clientDTO) {

        return new ResponseEntity<>(service.addClient(clientDTO), HttpStatus.OK);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable int clientId, @Valid @RequestBody ClientDTO client) {

        return new ResponseEntity<>(service.updateClient(clientId, client), HttpStatus.OK);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClient(@PathVariable int clientId) {

        service.deleteClient(clientId);
        return new ResponseEntity<>("Client deleted!", HttpStatus.OK);
    }
}
