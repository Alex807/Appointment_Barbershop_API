package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.model.ClientDTO;
import com.AlexBurada.Barbershop.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/clients")
@Validated
public class ClientController {

    private final ClientService service;

    public ClientController(final ClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients() {

        List<ClientDTO> clients = service.getClients();

        if (clients.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable int clientId) {

        ClientDTO client = service.getClientById(clientId);

        if (client == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Client '%s' NOT found!", clientId));
        else
            return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@Valid @RequestBody ClientDTO clientDTO) {

        ClientDTO client = service.addClient(clientDTO);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable int clientId, @Valid @RequestBody ClientDTO clientDTO) {

        try {

        } catch (ChangeSetPersister.NotFoundException)
        ClientDTO client = service.updateClient(clientDTO);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

//    @Delete
}
