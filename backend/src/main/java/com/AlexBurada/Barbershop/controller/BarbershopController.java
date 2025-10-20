package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.model.BarbershopDTO;
import com.AlexBurada.Barbershop.model.ClientDTO;
import com.AlexBurada.Barbershop.service.BarbershopService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/barbershops")
@Validated
public class BarbershopController {

    private final BarbershopService service;

    public BarbershopController(final BarbershopService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BarbershopDTO>> getBarbershops() {

        List<BarbershopDTO> barbershops = service.getBarbershops();

        if (barbershops.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(barbershops, HttpStatus.OK);
    }

    @GetMapping("/{city}")
    public ResponseEntity<List<BarbershopDTO>> getBarbershopsByCity(@PathVariable String city) {

        List<BarbershopDTO> barbershops = service.getBarbershopsByCity(city);

        if (barbershops.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(barbershops, HttpStatus.OK);
    }

    @GetMapping("/{barbershopId}")
    public ResponseEntity<BarbershopDTO> getBarbershopById(@PathVariable int barbershopId) {

        BarbershopDTO barbershop = service.getBarbershopById(barbershopId);

        if (barbershop == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Barbershop '%s' NOT found!", barbershopId));
        else
            return new ResponseEntity<>(barbershop, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BarbershopDTO> addBarbershop(@Valid @RequestBody BarbershopDTO barbershopDTO) {

        BarbershopDTO barbershop = service.addBarbershop(barbershopDTO);

        return new ResponseEntity<>(barbershop, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BarbershopDTO> updateBarbershop(@Valid @RequestBody BarbershopDTO barbershopDTO) {

        BarbershopDTO barbershop = service.updateBarbershop(barbershopDTO);

        return new ResponseEntity<>(barbershop, HttpStatus.OK);
    }
}
