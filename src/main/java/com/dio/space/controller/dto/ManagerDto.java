package com.dio.space.controller.dto;

import com.dio.space.domain.model.Manager;
import com.dio.space.domain.model.ManagerAddresses;

import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;


import static java.util.Optional.ofNullable;

public record ManagerDto(
     String firstName,
     String lastName,
     String email,
     int age,
     int credential,
     List<AddressDto> addresses){

    public ManagerDto(Manager model) {
        this(
                model.getFirstName(),
                model.getLastName(),
                model.getEmail(),
                model.getAge(),
                model.getCredential(),
                ofNullable(model.getAddresses())
                .orElse(Collections.emptyList())
                .stream()
                        .map(ManagerAddresses::getAddress)
                .map(AddressDto::new)
                .collect(Collectors.toList())
        );

    }


    public Manager toManager(){
        Manager manager = new Manager();
        manager.setFirstName(this.firstName);
        manager.setLastName(this.lastName);
        manager.setEmail(this.email);
        manager.setAge(this.age);
        manager.setCredential(this.credential);

        return manager;
    }
}