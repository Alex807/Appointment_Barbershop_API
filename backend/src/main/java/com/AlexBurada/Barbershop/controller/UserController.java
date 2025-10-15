package com.AlexBurada.Barbershop.controller;

import com.AlexBurada.Barbershop.dto.User;
import com.AlexBurada.Barbershop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public List<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable int userId) {
        return service.getUserById(userId);
    }


}
