package com.dio.space.controller.dto;

import com.dio.space.domain.model.Rocket;

import java.time.LocalDateTime;

public record RocketDto(
        String id,
        String name,
        String type,
        double height,
        double diameter,
        double mass,
        int firstStageEngines,
        double firstStageFuel,
        int secondStageEngines,
        double secondStageFuel,
        String description,
        boolean active,
        int costPerLaunch,
        String company,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public RocketDto(Rocket rocket) {
        this(
                rocket.getId(),
                rocket.getName(),
                rocket.getType(),
                rocket.getHeight(),
                rocket.getDiameter(),
                rocket.getMass(),
                rocket.getFirstStageEngines(),
                rocket.getFirstStageFuel(),
                rocket.getSecondStageEngines(),
                rocket.getSecondStageFuel(),
                rocket.getDescription(),
                rocket.isActive(),
                rocket.getCostPerLaunch(),
                rocket.getCompany(),
                rocket.getCreatedAt(),
                rocket.getUpdatedAt()
        );
    }
}