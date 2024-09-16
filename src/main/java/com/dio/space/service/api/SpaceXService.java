package com.dio.space.service.api;

import com.dio.space.controller.dto.PayloadDto;
import com.dio.space.service.api.apidto.RocketApiDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "spacex", url = "https://api.spacexdata.com/v4")
public interface SpaceXService {

    @GetMapping("/rockets/{id}")
    RocketApiDto getRocket(@PathVariable("id") String id);

    @GetMapping("/payloads/{id}")
    PayloadDto getPayload(@PathVariable("id") String id);
}