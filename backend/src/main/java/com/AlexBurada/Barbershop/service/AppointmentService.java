package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.dto.AppointmentDTO;
import com.AlexBurada.Barbershop.exception.ResourceNotFoundException;
import com.AlexBurada.Barbershop.repository.AppointmentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepo repository;

    public AppointmentService(final AppointmentRepo repository) { //can re-assign a received reference
        this.repository = repository;
    }

    public List<AppointmentDTO> getAppointments() {
        return repository.findAll();
    }

    public AppointmentDTO getAppointmentById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Appointment '%s' NOT found!", id), HttpStatus.NOT_FOUND));
    }

    public AppointmentDTO addAppointment(AppointmentDTO appointmentDTO) {
        return repository.save(appointmentDTO);
    }

    @Transactional
    public AppointmentDTO updateAppointment(int appointmentId, AppointmentDTO appointmentDTO) {
        AppointmentDTO existingAppointment = getAppointmentById(appointmentId);

        existingAppointment.setService(appointmentDTO.getService());
        existingAppointment.setPrice(appointmentDTO.getPrice());
        existingAppointment.setScheduled_date(appointmentDTO.getScheduled_date());

        return repository.save(existingAppointment);
    }

    public void deleteAppointment(int id) {

        AppointmentDTO existingAppointment = getAppointmentById(id);
        repository.delete(existingAppointment);
    }
}
