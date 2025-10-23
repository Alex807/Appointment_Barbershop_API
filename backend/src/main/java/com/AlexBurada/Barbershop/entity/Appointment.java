package com.AlexBurada.Barbershop.entity;

import com.AlexBurada.Barbershop.dto.AppointmentDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;
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
    private Integer id;

    @NotBlank(message = "Service can't be blank!")
    @Size(min = 3, max = 30, message = "Service must be between 3 and 30 characters")
    private String service;

    @Range(min = 5, message = "Lowest price is 5$, but no upside limit ")
    private Double price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @NotNull(message = "Date can't be blank!")
    @Column(name = "scheduled_date")
    private LocalDateTime scheduledDate;

    @Column(name = "tips")
    @ColumnDefault(value = "2.5")
    private Double givenTips;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "barber_id")
    private Barber barber;

    @ManyToOne
    @JoinColumn(name = "barbershop_id", nullable = false)
    private Barbershop barbershop;

    public Appointment (AppointmentDTO appointmentDTO) {
        update(appointmentDTO);
    }

    public void update(AppointmentDTO appointmentDTO) {
        this.service = appointmentDTO.service();
        this.price = appointmentDTO.price();
        this.scheduledDate = appointmentDTO.scheduledDate();
    }
}
