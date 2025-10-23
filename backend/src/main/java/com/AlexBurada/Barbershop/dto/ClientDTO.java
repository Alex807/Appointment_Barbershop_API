package com.AlexBurada.Barbershop.dto;

public record ClientDTO(
        String name,
        String email,
        String phone
) {
    //records ar used to reduce boiler code such constructor + setters/getters
}