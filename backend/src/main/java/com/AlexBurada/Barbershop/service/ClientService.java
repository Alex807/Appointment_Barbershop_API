package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.exception.DtoNotFoundException;
import com.AlexBurada.Barbershop.dto.ClientDTO;
import com.AlexBurada.Barbershop.repository.ClientRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return repository.findById(id)
                        .orElseThrow(() -> new DtoNotFoundException(String.format("Client '%s' NOT found!", id), HttpStatus.NOT_FOUND));
    }


    public ClientDTO addClient(ClientDTO clientDTO) {
        return repository.save(clientDTO);
    }

    @Transactional //makes the operation atomic(all or none steps, nothing partial)
    public ClientDTO updateClient(int clientId, ClientDTO clientDTO) {
        ClientDTO existingClient = getClientById(clientId);

        existingClient.setName(clientDTO.getName());
        existingClient.setEmail(clientDTO.getEmail());
        existingClient.setPhone(clientDTO.getPhone());

        return repository.save(existingClient);
    }

    public void deleteClient(int id) {

        ClientDTO existingClient = getClientById(id);
        repository.delete(existingClient);
    }
}
