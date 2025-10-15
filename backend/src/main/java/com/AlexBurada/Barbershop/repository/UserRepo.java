package com.AlexBurada.Barbershop.repository;

import com.AlexBurada.Barbershop.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
