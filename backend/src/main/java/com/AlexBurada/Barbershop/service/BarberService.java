package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.dto.BarberDTO;
import com.AlexBurada.Barbershop.entity.Barber;
import com.AlexBurada.Barbershop.exception.ResourceNotFoundException;
import com.AlexBurada.Barbershop.repository.BarberRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException(String.format("Barber '%s' NOT found!", id), HttpStatus.NOT_FOUND));
    }

    public BarberDTO addBarber(BarberDTO barberDTO) {
        return repository.save(barberDTO);
    }

    @Transactional
    public BarberDTO updateBarber(int barberId, BarberDTO barberDTO) {
        BarberDTO existingBarber = getBarberById(barberId);

        existingBarber.setName(barberDTO.getName());
        existingBarber.setSpeciality(barberDTO.getSpeciality());
        existingBarber.setYears_of_experience(barberDTO.getYears_of_experience());
        existingBarber.setPhone(barberDTO.getPhone());

        return repository.save(existingBarber);
    }

    public void deleteBarber(int id) {

        BarberDTO existingBarber = getBarberById(id);
        repository.delete(existingBarber);
    }
}
