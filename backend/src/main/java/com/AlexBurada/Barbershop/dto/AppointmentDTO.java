package com.AlexBurada.Barbershop.dto;

import java.time.LocalDateTime;

public record AppointmentDTO (
        String service,
        Double price,
        LocalDateTime scheduledDate
) {

}