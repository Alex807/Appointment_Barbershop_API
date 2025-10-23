package com.AlexBurada.Barbershop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "appointments")
public class AppointmentDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Service can't be blank!")
    @Size(min = 3, max = 30, message = "Service must be between 3 and 30 characters")
    private String service;

    @DecimalMin(value = "5.5", message = "Lowest price is 5.5$, but no upside limit ")
    private Double price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message = "Date can't be blank!")
    private Date scheduled_date;


    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientDTO client;

    @ManyToOne
    @JoinColumn(name = "barber_id")
    private BarberDTO barber;

    @ManyToOne
    @JoinColumn(name = "barbershop_id", nullable = false) 
    private BarbershopDTO barbershop;
}
