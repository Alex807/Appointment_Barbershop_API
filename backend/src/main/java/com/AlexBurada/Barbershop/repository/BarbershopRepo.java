package com.AlexBurada.Barbershop.repository;

import com.AlexBurada.Barbershop.dto.Barbershop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarbershopRepo extends JpaRepository<Barbershop, Integer> {

    //Spring Data JPA implements method by their naming
    List<Barbershop> findByCityIgnoreCase(String city);
}
