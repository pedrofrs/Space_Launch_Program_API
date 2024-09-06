package com.dio.space.controller;

import com.dio.space.model.DTO.ManagerDTO;
import com.dio.space.model.Manager;
import com.dio.space.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/manager")  // Corrigido o caminho para "/manager"
public class ManagerController {

    @Autowired
    private ManagerService managerServiceImplement;

    @GetMapping("/all")
    public ResponseEntity<List<ManagerDTO>> getAll() {
        var managers = managerServiceImplement.findAll();
        List<ManagerDTO> managerDTO = managers.stream().map(ManagerDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(managerDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManagerDTO> getById(@PathVariable Long id) {
        var manager = managerServiceImplement.findById(id);
        return ResponseEntity.ok(new ManagerDTO(manager));
    }

    @PostMapping
    public ResponseEntity<ManagerDTO> create (@RequestBody ManagerDTO managerDTO) {
        var manager = managerDTO.toManager();
        managerServiceImplement.create(manager);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(manager.getId())
                .toUri();
        return ResponseEntity.created(location).body(new ManagerDTO(manager));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ManagerDTO> update(@PathVariable Long id, @RequestBody ManagerDTO managerDTO) {
        try {
            var manager = managerDTO.toManager();
            Manager updatedManager = managerServiceImplement.update(id, manager);
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
