package com.AlexBurada.Barbershop.repository;

import com.AlexBurada.Barbershop.dto.Barbershop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarbershopRepo extends JpaRepository<Barbershop, Integer> {

}
