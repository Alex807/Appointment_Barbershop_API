package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.dto.Barber;
import com.AlexBurada.Barbershop.service.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/barbers")
public class BarberController {

    @Autowired
    private BarberService service;

    @GetMapping("/")
    public List<Barber> getBarbers() {
        return service.getBarbers();
    }

    @GetMapping("/{id}")
    public Barber getBarberById(@PathVariable int id) {
        return service.getBarberById(id);
    }
}
