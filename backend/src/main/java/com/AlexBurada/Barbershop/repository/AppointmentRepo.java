package com.AlexBurada.Barbershop.repository;

import com.AlexBurada.Barbershop.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

}
