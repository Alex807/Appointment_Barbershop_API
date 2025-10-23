package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.entity.Client;
import com.AlexBurada.Barbershop.exception.ResourceNotFoundException;
import com.AlexBurada.Barbershop.dto.ClientDTO;
import com.AlexBurada.Barbershop.mapper.ClientDTOMapper;
import com.AlexBurada.Barbershop.repository.ClientRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepo repository;
    private final ClientDTOMapper clientMapper;

    public ClientService(final ClientRepo repository, final ClientDTOMapper mapper) {
        this.repository = repository;
        this.clientMapper = mapper;
    }

    public List<ClientDTO> getClients() {
        return repository.findAll()
                .stream()
                .map(clientMapper)
                .collect(Collectors.toList());
    }

    public ClientDTO getClientById(int id) {
        return repository.findById(id)
                        .map(clientMapper)
                        .orElseThrow(() -> new ResourceNotFoundException("Client [%s] NOT found!".formatted(id), HttpStatus.NOT_FOUND));
    }


    public void addClient(ClientDTO clientDTO) { //we work with DTO's to hide important data from user
        Client client = new Client(clientDTO);

        repository.save(client);
    }

    @Transactional //makes the operation atomic(all or none steps, nothing partial)
    public void updateClient(int clientId, ClientDTO clientDTO) {
        Client existingClient = repository.findById(clientId)
                        .orElseThrow(() -> new ResourceNotFoundException("Client [%s] NOT found!".formatted(clientId), HttpStatus.NOT_FOUND));

        existingClient.update(clientDTO);
        repository.save(existingClient);
    }

    public void deleteClient(int id) {

        getClientById(id); //if DTO exists, means also that entity exists and can be deleted
        repository.deleteById(id);
    }
}
