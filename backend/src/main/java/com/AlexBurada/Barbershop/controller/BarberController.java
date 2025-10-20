package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.model.BarberDTO;
import com.AlexBurada.Barbershop.model.ClientDTO;
import com.AlexBurada.Barbershop.service.BarberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/barbers")
@Validated
public class BarberController {

    private final BarberService service;

    public BarberController(final BarberService barberService) {
        this.service = barberService;
    }

    @GetMapping
    public ResponseEntity<List<BarberDTO>> getBarbers() {

        List<BarberDTO> barbers = service.getBarbers();

        if (barbers.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(barbers, HttpStatus.OK);
    }

    @GetMapping("/{barberId}")
    public ResponseEntity<BarberDTO> getBarberById(@PathVariable int barberId) {

        BarberDTO barber = service.getBarberById(barberId);

        if (barber == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Barber '%s' NOT found!", barberId));
        else
            return new ResponseEntity<>(barber, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BarberDTO> addBarber(@Valid @RequestBody BarberDTO barberDTO) {

        BarberDTO barber = service.addBarber(barberDTO);

        return new ResponseEntity<>(barber, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BarberDTO> updateBarber(@Valid @RequestBody BarberDTO barberDTO) {

        BarberDTO barber = service.updateBarber(barberDTO);

        return new ResponseEntity<>(barber, HttpStatus.OK);
    }
}
