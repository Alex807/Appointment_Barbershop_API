package com.AlexBurada.Barbershop.repository;

import com.AlexBurada.Barbershop.dto.Barber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarberRepo extends JpaRepository<Barber, Integer> {

}
