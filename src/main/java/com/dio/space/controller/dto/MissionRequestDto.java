package com.dio.space.controller.dto;

import java.time.LocalDateTime;

public record MissionRequestDto(
        String name,
        String description,
        LocalDateTime date,
        Boolean success,
        Long managerId,
        Long payloadId,
        String rocketId
) {}