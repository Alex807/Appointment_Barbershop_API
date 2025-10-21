package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.dto.BarbershopDTO;
import com.AlexBurada.Barbershop.repository.BarbershopRepo;
import org.springframework.stereotype.Service;

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
        return repository.findById(id).orElse(null);
    }

    public BarbershopDTO addBarbershop(BarbershopDTO barbershopDTO) {
        return repository.save(barbershopDTO);
    }

    public BarbershopDTO updateBarbershop(BarbershopDTO barbershopDTO) {
        return repository.save(barbershopDTO);
    }

    public void deleteBarbershop(int id) {
        repository.deleteById(id);
    }
}
