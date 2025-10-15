package com.AlexBurada.Barbershop.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "barbershop")
public class Barbershop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String street;
    private int street_no;
    private String phone;

    @OneToMany(mappedBy = "barbershop", cascade = CascadeType.ALL)
    private List<Barber> barbers = new ArrayList<>();
    
    @OneToMany(mappedBy = "barbershop", cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

}
