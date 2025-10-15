package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.dto.Appointment;
import com.AlexBurada.Barbershop.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo repository;

    public List<Appointment> getAppointments() {
        return repository.findAll();
    }

    public Appointment getAppointmentById(int id) {
        return repository.findById(id).get();
    }
}
