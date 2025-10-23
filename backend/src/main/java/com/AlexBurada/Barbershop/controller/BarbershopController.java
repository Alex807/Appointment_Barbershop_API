package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.dto.BarbershopDTO;
import com.AlexBurada.Barbershop.service.BarbershopService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<BarbershopDTO>> getBarbershops() {

        return new ResponseEntity<>(service.getBarbershops(), HttpStatus.OK);
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<List<BarbershopDTO>> getBarbershopsByCity(@PathVariable String city) {

        return new ResponseEntity<>(service.getBarbershopsByCity(city), HttpStatus.OK);
    }

    @GetMapping("/{barbershopId}")
    public ResponseEntity<BarbershopDTO> getBarbershopById(@PathVariable int barbershopId) {

        return new ResponseEntity<>(service.getBarbershopById(barbershopId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addBarbershop(@Valid @RequestBody BarbershopDTO barbershopDTO) {

        service.addBarbershop(barbershopDTO);
        return new ResponseEntity<>("Barbershop added successfully!", HttpStatus.OK);
    }

    @PutMapping("/{barbershopId}")
    public ResponseEntity<String> updateBarbershop(@PathVariable int barbershopId, @Valid @RequestBody BarbershopDTO barbershopDTO) {

        service.updateBarbershop(barbershopId, barbershopDTO);
        return new ResponseEntity<>("Barbershop updated successfully!", HttpStatus.OK);
    }

    @DeleteMapping("/{barbershopId}")
    public ResponseEntity<String> deleteBarbershop(@PathVariable int barbershopId) {

        service.deleteBarbershop(barbershopId);
        return new ResponseEntity<>("Barbershop deleted!", HttpStatus.OK);
    }
}
