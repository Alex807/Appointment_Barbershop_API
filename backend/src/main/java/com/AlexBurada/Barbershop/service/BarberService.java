package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.model.BarberDTO;
import com.AlexBurada.Barbershop.repository.BarberRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberService {

    private final BarberRepo repository;

    public BarberService(final BarberRepo repository) {
        this.repository = repository;
    }

    public List<BarberDTO> getBarbers() {
        return repository.findAll();
    }

    public BarberDTO getBarberById(int id) {
        return repository.findById(id).orElse(null);
    }

    public BarberDTO addBarber(BarberDTO barberDTO) {
        return repository.save(barberDTO);
    }

    public BarberDTO updateBarber(BarberDTO barberDTO) {
        return repository.save(barberDTO);
    }

    public void deleteBarber(int id) {
        repository.deleteById(id);
    }
}
