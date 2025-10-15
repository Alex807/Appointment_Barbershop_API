package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.dto.Appointment;
import com.AlexBurada.Barbershop.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping("/")
    public List<Appointment> getAppointments() {
        return service.getAppointments();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable int id) {
        return service.getAppointmentById(id);
    }
}
