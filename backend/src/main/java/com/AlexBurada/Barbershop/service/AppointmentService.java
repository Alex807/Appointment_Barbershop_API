package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.dto.AppointmentDTO;
import com.AlexBurada.Barbershop.entity.Appointment;
import com.AlexBurada.Barbershop.exception.ResourceNotFoundException;
import com.AlexBurada.Barbershop.mapper.AppointmentDTOMapper;
import com.AlexBurada.Barbershop.repository.AppointmentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepo repository;
    private final AppointmentDTOMapper mapper;

    public AppointmentService(final AppointmentRepo repository, final AppointmentDTOMapper mapper) { //can re-assign a received reference
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<AppointmentDTO> getAppointments() {
        return repository.findAll()
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    public AppointmentDTO getAppointmentById(int id) {
        return repository.findById(id)
                .map(mapper)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Appointment '%s' NOT found!", id), HttpStatus.NOT_FOUND));
    }

    public void addAppointment(AppointmentDTO appointmentDTO) {

        Appointment appointment = new Appointment(appointmentDTO);
        repository.save(appointment);
    }

    @Transactional
    public void updateAppointment(int appointmentId, AppointmentDTO appointmentDTO) {
        Appointment existingAppointment = repository.findById(appointmentId)
                        .orElseThrow(() -> new ResourceNotFoundException("Appointment [%s] NOT found!".formatted(appointmentId), HttpStatus.NOT_FOUND));

        existingAppointment.update(appointmentDTO);
        repository.save(existingAppointment);
    }

    public void deleteAppointment(int id) {

        getAppointmentById(id);
        repository.deleteById(id);
    }
}
