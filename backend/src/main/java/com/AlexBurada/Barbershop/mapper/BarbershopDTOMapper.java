package com.AlexBurada.Barbershop.mapper;

import com.AlexBurada.Barbershop.dto.BarbershopDTO;
import com.AlexBurada.Barbershop.entity.Barbershop;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class BarbershopDTOMapper implements Function<Barbershop, BarbershopDTO> {

    @Override
    public BarbershopDTO apply(Barbershop barbershop) {
        return new BarbershopDTO(
                barbershop.getName(),
                barbershop.getCity(),
                barbershop.getStreetName(),
                barbershop.getStreetNumber(),
                barbershop.getPhone()
        );
    }
}
