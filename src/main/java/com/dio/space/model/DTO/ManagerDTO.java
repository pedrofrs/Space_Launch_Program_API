package com.dio.space.model.DTO;

import com.dio.space.model.Manager;
import com.dio.space.model.ManagerAddresses;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


import static java.util.Optional.ofNullable;

public record ManagerDTO (
     String firstName,
     String lastName,
     String email,
     int age,
     int credential,
     Set<AddressDTO> addresses){

    public ManagerDTO(Manager model) {
        this(
                model.getFirstName(),
                model.getLastName(),
                model.getEmail(),
                model.getAge(),
                model.getCredential(),
                ofNullable(model.getAddresses())
                .orElse(Collections.emptySet())
                .stream()
                        .map(ManagerAddresses::getAddress)
                .map(AddressDTO::new)
                .collect(Collectors.toSet())
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