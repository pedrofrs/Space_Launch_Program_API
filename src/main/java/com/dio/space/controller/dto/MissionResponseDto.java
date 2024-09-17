package com.dio.space.controller.dto;

import com.dio.space.domain.model.Mission;

import java.time.LocalDateTime;

public record MissionResponseDto(
        Long id,
        String name,
        String description,
        LocalDateTime date,
        Boolean success,
        PayloadDto payload,
        RocketDto rocket,
        ManagerDto manager
) {
    public MissionResponseDto(Mission mission){
        this(
                mission.getId(),
                mission.getName(),
                mission.getDescription(),
                mission.getMissionData(),
                mission.isSucess(),
                new PayloadDto(mission.getPayload()),
                new RocketDto(mission.getRocket()),
                new ManagerDto(mission.getManager())
        );
    }

}