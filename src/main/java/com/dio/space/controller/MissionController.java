package com.dio.space.controller;

import com.dio.space.controller.dto.MissionRequestDto;
import com.dio.space.controller.dto.MissionResponseDto;
import com.dio.space.service.MissionService;
import com.dio.space.service.impl.MissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/missions")
public class MissionController {
    @Autowired
    MissionServiceImpl missionService;

    @GetMapping
    public ResponseEntity<List<MissionResponseDto>> getAllMission(){
        var missions = missionService.findAll();
        return ResponseEntity.ok().body(missions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionResponseDto> getMissionById(@PathVariable Long id){
        var mission = missionService.findById(id);
        return ResponseEntity.ok().body(mission);
    }

    @PostMapping
    public ResponseEntity<MissionResponseDto> addMission(@RequestBody MissionRequestDto missionRequestDto){
        var mission = missionService.create(missionRequestDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mission.id())
                .toUri();
        return ResponseEntity.created(location).body(mission);

    }
}
