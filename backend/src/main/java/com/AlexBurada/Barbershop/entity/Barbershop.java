package com.AlexBurada.Barbershop.entity;

import com.AlexBurada.Barbershop.dto.BarbershopDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "barbershops",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "barbershop need unique <location>",
                        columnNames = {"name", "city", "street", "street_no"}
                )
        }
)
public class Barbershop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name can't be blank!")
    @Size(min = 3, max = 40, message = "Name must be between 3 and 40 characters")
    @Pattern(regexp = "^[a-zA-Z\\s'-]+$", message = "Name format is invalid!")
    private String name;

    @NotBlank(message = "City can't be blank!")
    @Size(min = 3, max = 20, message = "City must be between 3 and 20 characters")
    private String city;

    @NotBlank(message = "Street can't be blank!")
    @Size(min = 3, max = 25, message = "Street must be between 3 and 25 characters")
    @Column(name = "street_name")
    private String streetName;

    @Column(name = "street_no")
    @Range(min = 1, max = 300, message = "Street_no can't be blank!")
    private Integer streetNumber;

    @Size(min = 10, max = 15, message = "Phone needs 10 characters to be valid")
    private String phone;

    @Range(min = 0, max = 100, message = "The profitability can exceed 0 - 100% range!")
    @ColumnDefault("1.5")
    private Double profitabilityPercent;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Column(name = "enrolled_at")
    @CreationTimestamp
    private LocalDateTime enrolledAt;

    public Barbershop (BarbershopDTO barbershopDTO) {
        update(barbershopDTO);
    }

    public void  update (BarbershopDTO barbershopDTO) {
        this.name = barbershopDTO.name();
        this.city = barbershopDTO.city();
        this.streetName = barbershopDTO.streetName();
        this.streetNumber = barbershopDTO.streetNumber();
        this.phone = barbershopDTO.phone();
    }

}

