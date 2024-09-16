package com.dio.space.controller;

import com.dio.space.controller.dto.PayloadDto;
import com.dio.space.service.PayloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/payloads")
public class PayloadController {

    @Autowired
    private PayloadService payloadService;

    @GetMapping("/all")
    public ResponseEntity<List<PayloadDto>> getAll() {
        var payloads = payloadService.findAll();
        return ResponseEntity.ok(payloads);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PayloadDto> getById(@PathVariable Long id) {
        var payloadDto = payloadService.findById(id);
        return ResponseEntity.ok(payloadDto);
    }

    @PostMapping
    public ResponseEntity<PayloadDto> create(@RequestBody PayloadDto payloadDto) {
        var createdPayload = payloadService.create(payloadDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdPayload.id())
                .toUri();
        return ResponseEntity.created(location).body(createdPayload);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PayloadDto> update(@PathVariable Long id, @RequestBody PayloadDto payloadDto) {
        var updatedPayload = payloadService.update(id, payloadDto);
        return ResponseEntity.ok(updatedPayload);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        payloadService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
