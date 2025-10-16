package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.dto.Client;
import com.AlexBurada.Barbershop.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepo repository;

    public List<Client> getClients() {
        return repository.findAll();
    }

    public Client getClientById(int id) {
        return repository.findById(id).get();
    }

    public void addClient(Client client) {
        repository.save(client);
    }

    public void updateClient(Client client) {
        repository.save(client);
    }

    public void deleteClient(int id) {
        repository.deleteById(id);
    }
}
