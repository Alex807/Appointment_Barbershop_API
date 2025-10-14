package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.dto.Barbershop;
import com.AlexBurada.Barbershop.service.BarbershopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/barbershops")
public class BarbershopController {

    @Autowired
    private BarbershopService service;

    @GetMapping("/")
    public List<Barbershop> getBarbershops() {
        return service.getBarbershops();
    }

    @GetMapping("/{id}")
    public Barbershop getBarbershopById(@PathVariable int id) {
        return service.getBarbershopById(id);
    }
}
