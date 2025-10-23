package com.AlexBurada.Barbershop.entity;

import com.AlexBurada.Barbershop.dto.ClientDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "clients",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "client with 'name-email' unique",
                        columnNames = {"name", "email"}
                )
        }
)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Client name can't be blank!")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Name format is invalid!")
    private String name;

    @NotBlank(message = "Client email can't be blank!")
    @Email(message = "Email is not valid!")
    @Size(min = 3, max = 30, message = "Email must be between 3 and 30 characters")
    private String email;

    @Size(min = 10, max = 15, message = "Phone needs 10 characters to be valid")
    private String phone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    public Client(ClientDTO clientDTO) {
        update(clientDTO);
    }

    public void update(ClientDTO clientDTO) {
        this.name = clientDTO.name();
        this.email = clientDTO.email();
        this.phone = clientDTO.phone();
    }
}
