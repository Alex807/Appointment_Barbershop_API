package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.dto.BarberDTO;
import com.AlexBurada.Barbershop.service.BarberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<List<BarberDTO>> getBarbers() {

        return new ResponseEntity<>(service.getBarbers(), HttpStatus.OK);
    }

    @GetMapping("/{barberId}")
    public ResponseEntity<BarberDTO> getBarberById(@PathVariable int barberId) {

        return new ResponseEntity<>(service.getBarberById(barberId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BarberDTO> addBarber(@Valid @RequestBody BarberDTO barberDTO) {

        return new ResponseEntity<>(service.addBarber(barberDTO), HttpStatus.OK);
    }

    @PutMapping("/{barberId}")
    public ResponseEntity<BarberDTO> updateBarber(@PathVariable int barberId, @Valid @RequestBody BarberDTO barberDTO) {

        return new ResponseEntity<>(service.updateBarber(barberId, barberDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{barberId}")
    public ResponseEntity<String> deleteBarber(@PathVariable int barberId) {

        service.deleteBarber(barberId);
        return new ResponseEntity<>("Barber deleted!", HttpStatus.OK);
    }
}
