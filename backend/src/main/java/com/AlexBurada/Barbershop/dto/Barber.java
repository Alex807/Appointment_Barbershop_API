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
@Table(name = "barber")
public class Barber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int years_of_experience;

    @ManyToOne
    @JoinColumn(name = "barbershop_id", nullable = false)
    private Barbershop barbershop;

    @OneToMany(mappedBy = "barber", cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();
}
