package com.AlexBurada.Barbershop.entity;

import com.AlexBurada.Barbershop.dto.BarberDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "barbers",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "barber with 'name' unique",
                        columnNames = { "name" }
                )
        }
)
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name can't be blank!")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Name format is invalid!")
    private String name;

    @Size(min = 3, max = 20, message = "Speciality must be between 3 and 20 characters")
    private String speciality;

    @Range(min = 0, max = 30, message = "Experience need to be in range 0 - 30")
    @Column(name = "years_of_experience")
    private Integer yearsOfExperience;

    @Size(min = 10, max = 15, message = "Phone needs 10 characters to be valid")
    private String phone;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "barbershop_id", nullable = false)
    private Barbershop barbershop;

    public Barber (BarberDTO barberDTO) {
        update(barberDTO);
    }

    public void update(BarberDTO barberDTO) {
        this.name = barberDTO.name();
        this.speciality = barberDTO.speciality();
        this.yearsOfExperience = barberDTO.yearsOfExperience();
        this.phone = barberDTO.phone();
    }

}

