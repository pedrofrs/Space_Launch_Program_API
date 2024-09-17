package com.dio.space.service.impl;

import com.dio.space.controller.dto.MissionRequestDto;
import com.dio.space.controller.dto.MissionResponseDto;
import com.dio.space.domain.model.Manager;
import com.dio.space.domain.model.Mission;
import com.dio.space.domain.model.Payload;
import com.dio.space.domain.model.Rocket;
import com.dio.space.domain.repository.ManagerRepository;
import com.dio.space.domain.repository.MissionRepository;
import com.dio.space.domain.repository.PayloadRepository;
import com.dio.space.domain.repository.RocketRepository;
import com.dio.space.service.ManagerService;
import com.dio.space.service.MissionService;
import com.dio.space.service.PayloadService;
import com.dio.space.service.api.SpaceXService;
import com.dio.space.service.exception.NotFoundException;
import feign.FeignException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionServiceImpl {

    @Autowired
    MissionRepository missionRepository;
    @Autowired
    ManagerService managerService;
    @Autowired
    PayloadService payloadService;
    @Autowired
    RocketRepository rocketRepository;
    @Autowired
    SpaceXService spaceXService;

    @Autowired
    PayloadRepository payloadRepository;
    @Autowired
    ManagerRepository managerRepository;


    public List<MissionResponseDto> findAll() {
        return missionRepository.findAll().stream().map(MissionResponseDto::new).collect(Collectors.toList());
    }


    public MissionResponseDto findById(Long id) {

        return new MissionResponseDto(missionRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Mission not found.")));
    }


    public MissionResponseDto create(MissionRequestDto missionRequestDto) {

        Payload payload = payloadRepository.findById(missionRequestDto.payloadId()).get();
        Rocket rocket = selectRocket(missionRequestDto.rocketId());
        Manager manager = managerRepository.findById(missionRequestDto.managerId()).get();


        Mission mission = new Mission();
        mission.setName(missionRequestDto.name());
        mission.setDescription(missionRequestDto.description());
        mission.setMissionData(missionRequestDto.date());
        mission.setSucess(missionRequestDto.success());
        mission.setRocket(rocket);
        mission.setPayload(payload);
        mission.setManager(manager);
        missionRepository.save(mission);

        return new MissionResponseDto(missionRepository.save(mission));
    }


    public MissionResponseDto update(Long aLong, MissionResponseDto entity) {
        return null;
    }

    public void delete(Long aLong) {

    }

    private Rocket selectRocket(String id){
        Optional<Rocket> rocketDataBase = rocketRepository.findById(id);

        if (rocketDataBase.isEmpty()){
            try {
                return rocketRepository.save(spaceXService.getRocket(id).toRocket());
            }catch (FeignException exception){
                throw  new NotFoundException("Rocket not in data base or SpaceX API.");
            }

        }
        return rocketDataBase.get();
    }
}
