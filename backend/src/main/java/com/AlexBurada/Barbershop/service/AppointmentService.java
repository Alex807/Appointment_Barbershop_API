package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.dto.AppointmentDTO;
import com.AlexBurada.Barbershop.repository.AppointmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepo repository;

    public AppointmentService(final AppointmentRepo repository) {
        this.repository = repository;
    }

    public List<AppointmentDTO> getAppointments() {
        return repository.findAll();
    }

    public AppointmentDTO getAppointmentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public AppointmentDTO addAppointment(AppointmentDTO appointmentDTO) {
        return repository.save(appointmentDTO);
    }

    public AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO) {
        return repository.save(appointmentDTO);
    }

    public void deleteAppointment(int id) {
        repository.deleteById(id);
    }
}
