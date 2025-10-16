package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.dto.Barber;
import com.AlexBurada.Barbershop.repository.BarberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarberService {

    @Autowired
    private BarberRepo repository;

    public List<Barber> getBarbers() {
        return repository.findAll();
    }

    public Barber getBarberById(int id) {
        return repository.findById(id).get();
    }

    public void addBarber(Barber barber) {
        repository.save(barber);
    }

    public void updateBarber(Barber barber) {
        repository.save(barber);
    }

    public void deleteBarber(int id) {
        repository.deleteById(id);
    }
}
