package com.AlexBurada.Barbershop.repository;

import com.AlexBurada.Barbershop.model.BarbershopDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarbershopRepo extends JpaRepository<BarbershopDTO, Integer> {

    //Spring Data JPA implements method by their naming
    List<BarbershopDTO> findByCityIgnoreCase(String city);
}
