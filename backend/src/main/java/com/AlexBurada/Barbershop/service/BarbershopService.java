package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.dto.BarbershopDTO;
import com.AlexBurada.Barbershop.exception.ResourceNotFoundException;
import com.AlexBurada.Barbershop.repository.BarbershopRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BarbershopService {

    private final BarbershopRepo repository;

    public BarbershopService(final BarbershopRepo repository) {
        this.repository = repository;
    }

    public List<BarbershopDTO> getBarbershops() {
        return repository.findAll();
    }

    public List<BarbershopDTO> getBarbershopsByCity(String city) {
        return repository.findByCityIgnoreCase(city); //can declare custom methods in Spring JPA interface
    }

    public BarbershopDTO getBarbershopById(int id) {
        return repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(String.format("Barbershop '%s' NOT found!", id), HttpStatus.NOT_FOUND));
    }

    public BarbershopDTO addBarbershop(BarbershopDTO barbershopDTO) {
        return repository.save(barbershopDTO);
    }

    @Transactional
    public BarbershopDTO updateBarbershop(int barbershopId, BarbershopDTO barbershopDTO) {
        BarbershopDTO existingBarbershop = getBarbershopById(barbershopId);

        existingBarbershop.setName(barbershopDTO.getName());
        existingBarbershop.setCity(barbershopDTO.getCity());
        existingBarbershop.setStreet(barbershopDTO.getStreet());
        existingBarbershop.setStreet_no(barbershopDTO.getStreet_no());
        existingBarbershop.setPhone(barbershopDTO.getPhone());

        return repository.save(existingBarbershop);
    }

    public void deleteBarbershop(int id) {

        BarbershopDTO existingBarbershop = getBarbershopById(id);
        repository.delete(existingBarbershop);
    }
}
