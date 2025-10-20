package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.model.BarbershopDTO;
import com.AlexBurada.Barbershop.service.BarbershopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/barbershops")
public class BarbershopController {

    private final BarbershopService service;

    public BarbershopController(final BarbershopService service) {
        this.service = service;
    }

    @GetMapping
    public List<BarbershopDTO> getBarbershops() {
        return service.getBarbershops();
    }

    @GetMapping("/{id}")
    public BarbershopDTO getBarbershopById(@PathVariable int id) {
        return service.getBarbershopById(id);
    }

    @GetMapping("/{city}")
    public List<BarbershopDTO> getBarbershopByCity(@PathVariable String city) {
        return service.getBarbershopsByCity(city);
    }
}
