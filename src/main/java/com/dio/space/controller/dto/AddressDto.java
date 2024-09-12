package com.dio.space.controller.dto;

import com.dio.space.domain.model.Address;

public record AddressDto(
        String postalCode,
        String street,
        String neighborhood,
        String city,
        String state,
        String region,
        String federativeUnit){

    public AddressDto(Address address){
        this(
                address.getPostalCode(),
                address.getStreet(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getRegion(),
                address.getFederativeUnit()


        );
    }



}

