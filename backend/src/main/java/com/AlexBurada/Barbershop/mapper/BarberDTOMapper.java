package com.AlexBurada.Barbershop.mapper;

import com.AlexBurada.Barbershop.dto.BarberDTO;
import com.AlexBurada.Barbershop.entity.Barber;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class BarberDTOMapper  implements Function<Barber, BarberDTO> {

    @Override
    public BarberDTO apply(Barber barber) {
        return new BarberDTO(
                barber.getName(),
                barber.getSpeciality(),
                barber.getYearsOfExperience(),
                barber.getPhone()
        );
    }
}
