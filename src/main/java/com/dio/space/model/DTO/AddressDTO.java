package com.dio.space.model.DTO;

import com.dio.space.model.Address;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;



public record AddressDTO(
        String cep,
        String logradouro,
        String complemento,
        String unidade,
        String bairro,
        String localidade,
        String uf,
        String estado,
        String regiao,
        String ibge,
        String gia,
        String ddd) {

    public AddressDTO(Address address) {
        this(
                address.getPostalCode(),
                address.getStreet(),
                null,
                null,
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getRegion(),
                null,
                null,
                null,
                null

        );
    }

    public Address toAddress(){
        Address address = new Address();
        address.setPostalCode(this.cep);
        address.setStreet(this.logradouro);
        address.setNeighborhood(this.bairro);
        address.setCity(this.localidade);
        address.setRegion(this.regiao);
        address.setState(this.estado);
        return address;
    }

}