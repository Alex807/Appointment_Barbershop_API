package com.AlexBurada.Barbershop.mapper;

import com.AlexBurada.Barbershop.dto.ClientDTO;
import com.AlexBurada.Barbershop.entity.Client;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ClientDTOMapper implements Function<Client, ClientDTO> {

    @Override
    public ClientDTO apply(Client client) {
        return new ClientDTO (
                client.getName(),
                client.getEmail(),
                client.getPhone()
            );
    }
}
