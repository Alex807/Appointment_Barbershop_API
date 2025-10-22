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
@Table(name = "barbershops")
public class BarbershopDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Name can't be blank!")
    @Size(min = 3, max = 40, message = "Name must be between 3 and 40 characters")
    @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Name format is invalid!")
    private String name;

    @NotBlank(message = "City can't be blank!")
    @Size(min = 3, max = 20, message = "City must be between 3 and 20 characters")
    private String city;

    @NotBlank(message = "Street can't be blank!")
    @Size(min = 3, max = 25, message = "Street must be between 3 and 25 characters")
    private String street;

    @Range(min = 1, max = 300, message = "Street_no can't be blank!")
    private int street_no;

    @Size(min = 10, max = 15, message = "Phone needs 10 characters to be valid")
    private String phone;

}
