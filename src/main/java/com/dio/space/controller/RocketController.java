package com.dio.space.controller;

import com.dio.space.controller.dto.RocketDto;
import com.dio.space.service.impl.RocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rockets")
public class RocketController {
    @Autowired
    RocketService rocketService;

    @GetMapping()
    public ResponseEntity<List<RocketDto>> getRocket() {
        var allRockets = rocketService.getAll();
        return ResponseEntity.ok(allRockets);
    }
    @GetMapping("/{id}")
    public ResponseEntity<RocketDto> getRocketById(@PathVariable("id") String id) {
        var rocket = rocketService.getById(id);
        return ResponseEntity.ok(rocket);
    }

    @GetMapping("/{name}")
    public ResponseEntity<RocketDto> getRocketByName(@PathVariable("name") String name) {
        var rocket = rocketService.getByName(name);
        return ResponseEntity.ok(rocket);
    }

}
