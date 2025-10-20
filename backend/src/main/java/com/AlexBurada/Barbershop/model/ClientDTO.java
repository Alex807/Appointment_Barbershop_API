package com.AlexBurada.Barbershop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "client")
public class ClientDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Client name can't be blank!")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;

    @NotBlank(message = "Client email can't be blank!")
    @Email(message = "Email is not valid!")
    @Size(min = 3, max = 30, message = "Email must be between 3 and 30 characters")
    private String email;

    @Size(min = 10, max = 15, message = "Phone needs 10 characters to be valid")
    private String phone;
}
