package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.model.BarberDTO;
import com.AlexBurada.Barbershop.service.BarberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/barbers")
public class BarberController {

    private final BarberService service;

    public BarberController(final BarberService barberService) {
        this.service = barberService;
    }

    @GetMapping
    public List<BarberDTO> getBarbers() {
        return service.getBarbers();
    }

    @GetMapping("/{id}")
    public BarberDTO getBarberById(@PathVariable int id) {
        return service.getBarberById(id);
    }
}
