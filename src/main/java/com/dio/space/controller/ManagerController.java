package com.dio.space.controller;

import com.dio.space.controller.dto.ManagerDto;
import com.dio.space.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerServiceImplement;

    @GetMapping("/all")
    public ResponseEntity<List<ManagerDto>> getAll() {
        var managers = managerServiceImplement.findAll();
        return ResponseEntity.ok(managers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManagerDto> getById(@PathVariable Long id) {
        var manager = managerServiceImplement.findById(id);
        return ResponseEntity.ok(manager);
    }

    @PostMapping
    public ResponseEntity<ManagerDto> create (@RequestBody ManagerDto managerDTO) {
        var managerDtoResponse = managerServiceImplement.create(managerDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(managerDtoResponse.toManager().getId())
                .toUri();
        return ResponseEntity.created(location).body(managerDtoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManagerDto> update(@PathVariable Long id, @RequestBody ManagerDto managerDTO) {
        try {
            var manager = managerDTO.toManager();
            ManagerDto updatedManager = managerServiceImplement.update(id, managerDTO);
            return ResponseEntity.ok(managerDTO);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        managerServiceImplement.delete(id);
        return  ResponseEntity.noContent().build();
    }

}
