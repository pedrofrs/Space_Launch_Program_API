package com.dio.space.controller.dto;

import com.dio.space.domain.model.Payload;

public record PayloadDto(
        String id,
        String name,
        String type,
        boolean reused,
        String launch,
        double mass_kg,
        String orbit,
        String reference_system,
        String regime
) {

    public PayloadDto(Payload payload) {
        this(
        payload.getId().toString(),
        payload.getName(),
        payload.getType(),
        payload.isReused(),
        payload.getLaunch(),
        payload.getMassKg(),
        payload.getOrbit(),
        payload.getReferenceSystem(),
        payload.getRegime());
    }
    public Payload toPayload() {
        Payload payload = new Payload();
        payload.setName(this.name());
        payload.setType(this.type());
        payload.setReused(this.reused());
        payload.setLaunch(this.launch());
        payload.setMassKg(this.mass_kg());
        payload.setOrbit(this.orbit());
        payload.setReferenceSystem(this.reference_system());
        payload.setRegime(this.regime());
        return payload;
    }
}
