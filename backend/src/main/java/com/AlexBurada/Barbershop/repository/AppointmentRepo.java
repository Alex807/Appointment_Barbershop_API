package com.AlexBurada.Barbershop.repository;

import com.AlexBurada.Barbershop.model.AppointmentDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<AppointmentDTO, Integer> {

}
