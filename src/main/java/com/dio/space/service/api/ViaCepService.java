package com.dio.space.service.api;

import com.dio.space.service.api.apidto.AddressApiDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    @GetMapping("/{cep}/json/")
    AddressApiDto getCep(@PathVariable("cep") String cep);

}
