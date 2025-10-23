package com.AlexBurada.Barbershop.mapper;

import com.AlexBurada.Barbershop.dto.AppointmentDTO;
import com.AlexBurada.Barbershop.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AppointmentDTOMapper implements Function<Appointment, AppointmentDTO> {

    @Override
    public AppointmentDTO apply(Appointment appointment) {
        return new AppointmentDTO(
                appointment.getService(),
                appointment.getPrice(),
                appointment.getScheduledDate()
        );
    }
}
