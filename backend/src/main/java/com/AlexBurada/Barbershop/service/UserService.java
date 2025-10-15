package com.AlexBurada.Barbershop.service;

import com.AlexBurada.Barbershop.dto.User;
import com.AlexBurada.Barbershop.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo repository;

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(int id) {
        return repository.findById(id).get();
    }
}
