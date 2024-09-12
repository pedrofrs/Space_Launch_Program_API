package com.dio.space.service.api.apidto;

import com.dio.space.domain.model.Address;


public record AddressApiDto(
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

    public AddressApiDto(Address address) {
        this(
                address.getPostalCode(),
                address.getStreet(),
                null,
                null,
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getRegion(),
                address.getFederativeUnit(),
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
        address.setFederativeUnit(this.uf);
        return address;
    }

}
