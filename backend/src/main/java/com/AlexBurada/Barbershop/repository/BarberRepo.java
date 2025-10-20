package com.AlexBurada.Barbershop.repository;

import com.AlexBurada.Barbershop.model.BarberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepo extends JpaRepository<BarberDTO, Integer> {

}
