package com.AlexBurada.Barbershop.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "appointments",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "barber with 'name' unique",
                        columnNames = { "client", "scheldued_date" }
                )
        }
)
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Service can't be blank!")
    @Size(min = 3, max = 30, message = "Service must be between 3 and 30 characters")
    private String service;

    @Range(min = 5, message = "Lowest price is 5$, but no upside limit ")
    private double price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message = "Date can't be blank!")
    private Date scheduled_date;

    @Column(name = "tips")
    private double givenTips;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;

    @ManyToOne
    @JoinColumn(name = "barbershop_id", nullable = false)
    private Barbershop barbershop;
}
