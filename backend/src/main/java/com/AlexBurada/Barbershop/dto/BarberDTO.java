package com.AlexBurada.Barbershop.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "barbers")
public class BarberDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name can't be blank!")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Name format is invalid!")
    private String name;

    @Size(min = 3, max = 20, message = "Speciality must be between 3 and 20 characters")
    private String speciality;

    @Range(min = 0, max = 30, message = "Experience need to be in range 0 - 30")
    private int years_of_experience;

    @Size(min = 10, max = 15, message = "Phone needs 10 characters to be valid")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "barbershop_id", nullable = false)
    private BarbershopDTO barbershop;

}
