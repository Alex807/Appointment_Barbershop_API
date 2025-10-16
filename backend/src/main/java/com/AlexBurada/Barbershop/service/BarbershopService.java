package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.dto.Barbershop;
import com.AlexBurada.Barbershop.repository.BarbershopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbershopService {

    @Autowired
    private BarbershopRepo repository;

    public List<Barbershop> getBarbershops() {
        return repository.findAll();
    }

    public Barbershop getBarbershopById(int id) {
        return repository.findById(id).get();
    }

    public void addBarbershop(Barbershop barbershop) {
        repository.save(barbershop);
    }

    public void updateBarbershop(Barbershop barbershop) {
        repository.save(barbershop);
    }

    public void deleteBarbershop(int id) {
        repository.deleteById(id);
    }

    public List<Barbershop> getBarbershopsByCity(String city) {
        return repository.findByCityIgnoreCase(city); //can declare custom methods in Spring JPA interface
    }
}
