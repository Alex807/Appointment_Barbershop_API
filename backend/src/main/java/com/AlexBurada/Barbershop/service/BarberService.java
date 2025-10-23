package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.dto.BarberDTO;
import com.AlexBurada.Barbershop.entity.Barber;
import com.AlexBurada.Barbershop.exception.ResourceNotFoundException;
import com.AlexBurada.Barbershop.mapper.BarberDTOMapper;
import com.AlexBurada.Barbershop.repository.BarberRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BarberService {

    private final BarberRepo repository;
    private final BarberDTOMapper barberMapper;

    public BarberService(final BarberRepo repository, final BarberDTOMapper barberMapper) {
        this.repository = repository;
        this.barberMapper = barberMapper;
    }

    public List<BarberDTO> getBarbers() {
        return repository.findAll()
                .stream()
                .map(barberMapper)
                .collect(Collectors.toList());
    }

    public BarberDTO getBarberById(int id) {
        return repository.findById(id)
                .map(barberMapper)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Barber '%s' NOT found!", id), HttpStatus.NOT_FOUND));
    }

    public void addBarber(BarberDTO barberDTO) {

        Barber barber = new Barber(barberDTO);
        repository.save(barber);
    }

    @Transactional
    public void updateBarber(int barberId, BarberDTO barberDTO) {
        Barber existingBarber = repository.findById(barberId)
                        .orElseThrow(() -> new ResourceNotFoundException(String.format("Barber '%s' not found!", barberId), HttpStatus.NOT_FOUND));

        existingBarber.update(barberDTO);
        repository.save(existingBarber);
    }

    public void deleteBarber(int id) {

        getBarberById(id);
        repository.deleteById(id);
    }
}
