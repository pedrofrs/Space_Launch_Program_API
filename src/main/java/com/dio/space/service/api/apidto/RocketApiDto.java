package com.dio.space.service.api.apidto;

import com.dio.space.domain.model.Rocket;
import com.dio.space.service.api.model.Dimension;
import com.dio.space.service.api.model.Mass;
import com.dio.space.service.api.model.Stage;

public record RocketApiDto(
        String name,
        String type,
        Dimension height,
        Dimension diameter,
        Mass mass,
        Stage first_stage,
        Stage second_stage,
        String description,
        String id,
        boolean active,
        int cost_per_launch,
        String company
) {

    public Rocket toRocket() {
        Rocket rocket = new Rocket();
        rocket.setId(id);
        rocket.setName(name);
        rocket.setType(type);
        rocket.setHeight(height != null ? height.getMeters() : 0);
        rocket.setDiameter(diameter != null ? diameter.getMeters() : 0);
        rocket.setMass(mass != null ? mass.getKg() : 0);
        rocket.setFirstStageEngines(first_stage != null ? first_stage.getEngines(): 0);
        rocket.setFirstStageFuel(first_stage != null ? first_stage.getFuel_amount_tons() : 0);
        rocket.setSecondStageEngines(second_stage != null ? second_stage.getEngines() : 0);
        rocket.setSecondStageFuel(second_stage != null ? second_stage.getFuel_amount_tons() : 0);
        rocket.setDescription(description);
        rocket.setActive(active);
        rocket.setCostPerLaunch(cost_per_launch);
        rocket.setCompany(company);

        return rocket;
    }


}