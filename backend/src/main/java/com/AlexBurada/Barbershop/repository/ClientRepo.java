package com.AlexBurada.Barbershop.repository;

import com.AlexBurada.Barbershop.model.ClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepo extends JpaRepository<ClientDTO, Integer> {

}
