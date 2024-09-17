package com.dio.space.service.impl;

import com.dio.space.controller.dto.RocketDto;
import com.dio.space.domain.model.Rocket;
import com.dio.space.domain.repository.RocketRepository;
import com.dio.space.service.exception.BusinessException;
import com.dio.space.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RocketService {

    @Autowired
    RocketRepository rocketRepository;

    @Transactional(readOnly = true)
    public List<RocketDto> getAll(){
        return rocketRepository.findAll().stream().map(RocketDto::new)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public RocketDto getById(String id){
        RocketDto rocketDto = new RocketDto(rocketRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rocket not found in the database.")));
        return rocketDto;
    }
    @Transactional(readOnly = true)
    public RocketDto getByName(String name){
        RocketDto rocketDto = new RocketDto(rocketRepository.findByName(name));
        if (rocketDto == null){
            throw new NotFoundException("Rocket not found in the database.");
        }
        return rocketDto;
    }


}
