package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.dto.BarbershopDTO;
import com.AlexBurada.Barbershop.entity.Barbershop;
import com.AlexBurada.Barbershop.exception.ResourceNotFoundException;
import com.AlexBurada.Barbershop.mapper.BarbershopDTOMapper;
import com.AlexBurada.Barbershop.repository.BarbershopRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BarbershopService {

    private final BarbershopRepo repository;
    private final BarbershopDTOMapper mapper;

    public BarbershopService(final BarbershopRepo repository, final BarbershopDTOMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<BarbershopDTO> getBarbershops() {
        return repository.findAll()
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    public List<BarbershopDTO> getBarbershopsByCity(String city) {
        //can declare custom methods in Spring JPA interface
        return repository.findByCityIgnoreCase(city)
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    public BarbershopDTO getBarbershopById(int id) {
        return repository.findById(id)
                        .map(mapper)
                        .orElseThrow(() -> new ResourceNotFoundException("Barbershop [%s] NOT found!".formatted(id), HttpStatus.NOT_FOUND));
    }

    public void addBarbershop(BarbershopDTO barbershopDTO) {

        Barbershop barbershop = new Barbershop(barbershopDTO);
        repository.save(barbershop);
    }

    @Transactional
    public void updateBarbershop(int barbershopId, BarbershopDTO barbershopDTO) {
        Barbershop existingBarbershop = repository.findById(barbershopId)
                        .orElseThrow(() -> new ResourceNotFoundException("Barbershop [%s] NOT found!".formatted(barbershopId), HttpStatus.NOT_FOUND));

        existingBarbershop.update(barbershopDTO);
        repository.save(existingBarbershop);
    }

    public void deleteBarbershop(int id) {

        getBarbershopById(id);
        repository.deleteById(id);
    }
}
