package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.model.AppointmentDTO;
import com.AlexBurada.Barbershop.service.AppointmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService service; //only once can be assigned

    public AppointmentController(final AppointmentService service) { //thread-safe and unchanged received parameter
        this.service = service;
    }

    @GetMapping
    public List<AppointmentDTO> getAppointments() {
        return service.getAppointments();
    }

    @GetMapping("/{id}")
    public AppointmentDTO getAppointmentById(@PathVariable int id) {
        return service.getAppointmentById(id);
    }
}
