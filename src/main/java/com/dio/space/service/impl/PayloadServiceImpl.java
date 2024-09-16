package com.dio.space.service.impl;

import com.dio.space.controller.dto.PayloadDto;
import com.dio.space.domain.model.Payload;
import com.dio.space.domain.repository.PayloadRepository;
import com.dio.space.service.PayloadService;
import com.dio.space.service.api.SpaceXService;
import com.dio.space.service.exception.BusinessException;
import com.dio.space.service.exception.NotFoundException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;


@Service
public class PayloadServiceImpl implements PayloadService {

    @Autowired
    PayloadRepository payloadRepository;
    @Autowired
    SpaceXService spaceXService;


    @Override
    public List<PayloadDto> findAll() {
        return payloadRepository.findAll()
                .stream()
                .map(PayloadDto::new).collect(Collectors.toList());
    }

    @Override
    public PayloadDto findById(Long id ) {
        return payloadRepository.findById(id)
                .map(PayloadDto::new)
                .orElseThrow(() -> new NotFoundException("Payload not found"));
    }

    public PayloadDto create(PayloadDto payloadDto) {
        if (payloadDto.id() != null) {
            try {
                Payload payloadApi = spaceXService.getPayload(payloadDto.id()).toPayload();
                payloadApi.setCreatedAt(LocalDateTime.now());
                payloadApi.setUpdatedAt(LocalDateTime.now());
                Payload savedPayload = payloadRepository.save(payloadApi);
                return new PayloadDto(savedPayload);
            } catch (FeignException e) {
                throw new NotFoundException("Payload id not found. " + e);
            }
        } else {
            ofNullable(payloadDto.name()).orElseThrow(() -> new BusinessException("Payload name must not be null"));
            ofNullable(payloadDto.type()).orElseThrow(() -> new BusinessException("Payload type must not be null"));
            ofNullable(payloadDto.reused()).orElseThrow(() -> new BusinessException("Payload reuse information must not be null"));
            ofNullable(payloadDto.reference_system()).orElseThrow(() -> new BusinessException("Payload reference system must not be null"));
            ofNullable(payloadDto.mass_kg()).orElseThrow(() -> new BusinessException("Payload mass must not be null"));
            ofNullable(payloadDto.orbit()).orElseThrow(() -> new BusinessException("Payload orbit must not be null"));
            ofNullable(payloadDto.regime()).orElseThrow(() -> new BusinessException("Payload regime must not be null"));

            Payload payload = new Payload();
            updatePayloadFromDto(payload, payloadDto);
            payload.setCreatedAt(LocalDateTime.now());
            payload.setUpdatedAt(LocalDateTime.now());
            Payload savedPayload = payloadRepository.save(payload);
            return new PayloadDto(savedPayload);
        }
    }

    @Override
    public PayloadDto update(Long id, PayloadDto payloadDto) {
        Payload payload = payloadRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Manager not found with id: " + id));

        payload.setName(payloadDto.name());
        payload.setType(payloadDto.type());
        payload.setReused(payloadDto.reused());
        payload.setLaunch(payloadDto.launch());
        payload.setMassKg(payloadDto.mass_kg());
        payload.setOrbit(payloadDto.orbit());
        payload.setReferenceSystem(payloadDto.reference_system());
        payload.setRegime(payloadDto.regime());
        payloadRepository.save(payload);

        return  new PayloadDto(payload);
    }

    @Override
    public void delete(Long id) {
        if (!payloadRepository.existsById(id)) {
            throw new NotFoundException("Payload not found");
        }
        payloadRepository.deleteById(id);
    }
    private void updatePayloadFromDto(Payload payload, PayloadDto payloadDto) {
        payload.setName(payloadDto.name());
        payload.setType(payloadDto.type());
        payload.setReused(payloadDto.reused());
        payload.setLaunch(payloadDto.launch());
        payload.setMassKg(payloadDto.mass_kg());
        payload.setOrbit(payloadDto.orbit());
        payload.setReferenceSystem(payloadDto.reference_system());
        payload.setRegime(payloadDto.regime());
    }

}



