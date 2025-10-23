package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.dto.AppointmentDTO;
import com.AlexBurada.Barbershop.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(final AppointmentService service) { //thread-safe and unchanged received parameter
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> getAppointments() {

        return new ResponseEntity<>(service.getAppointments(), HttpStatus.OK);
    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable int appointmentId) {

        return new ResponseEntity<>(service.getAppointmentById(appointmentId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AppointmentDTO> addAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) {

        return new ResponseEntity<>(service.addAppointment(appointmentDTO), HttpStatus.OK);
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@PathVariable int appointmentId, @Valid @RequestBody AppointmentDTO appointmentDTO) {

        return new ResponseEntity<>(service.updateAppointment(appointmentId, appointmentDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<String> deleteAppointment(@PathVariable int appointmentId) {

        service.deleteAppointment(appointmentId);
        return new ResponseEntity<>("Appointment deleted!", HttpStatus.OK);
    }
}
