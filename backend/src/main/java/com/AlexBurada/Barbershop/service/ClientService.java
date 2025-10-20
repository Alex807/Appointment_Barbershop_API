package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.model.ClientDTO;
import com.AlexBurada.Barbershop.repository.ClientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepo repository;

    public ClientService(final ClientRepo repository) {
        this.repository = repository;
    }

    public List<ClientDTO> getClients() {
        return repository.findAll();
    }

    public ClientDTO getClientById(int id) {
        return repository.findById(id).orElse(null);
    }

    public ClientDTO addClient(ClientDTO clientDTO) {
        return repository.save(clientDTO);
    }

    public ClientDTO updateClient(ClientDTO clientDTO) {
        return repository.save(clientDTO);
    }

    public void deleteClient(int id) {
        repository.deleteById(id);
    }
}
