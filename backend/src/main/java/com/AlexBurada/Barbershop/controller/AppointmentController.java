package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.model.AppointmentDTO;
import com.AlexBurada.Barbershop.model.ClientDTO;
import com.AlexBurada.Barbershop.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/appointments")
@Validated
public class AppointmentController {

    private final AppointmentService service; //only once can be assigned

    public AppointmentController(final AppointmentService service) { //thread-safe and unchanged received parameter
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAppointments() {

        List<AppointmentDTO> appointments = service.getAppointments();

        if (appointments.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable int appointmentId) {

        AppointmentDTO appointment = service.getAppointmentById(appointmentId);

        if (appointment == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Appointment '%s' NOT found!", appointmentId));
        else
            return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> addAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) {

        AppointmentDTO appointment = service.addAppointment(appointmentDTO);

        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<AppointmentDTO> updateAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) {

        AppointmentDTO appointment = service.updateAppointment(appointmentDTO);

        return new ResponseEntity<>(appointment, HttpStatus.OK);
    }
}
