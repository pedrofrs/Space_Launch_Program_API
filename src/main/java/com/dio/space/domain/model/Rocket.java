package com.dio.space.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rockets")
public class Rocket {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "height_meters", nullable = false)
    private double height;

    @Column(name = "diameter_meters", nullable = false)
    private double diameter;

    @Column(name = "mass_kg", nullable = false)
    private double mass;

    @Column(name = "first_stage_engines", nullable = false)
    private int firstStageEngines;

    @Column(name = "first_stage_fuel", nullable = false)
    private double firstStageFuel;

    @Column(name = "second_stage_engines", nullable = false)
    private int secondStageEngines;

    @Column(name = "second_stage_fuel", nullable = false)
    private double secondStageFuel;

    @Column(name = "description")
    private String description;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "cost_per_launch")
    private int costPerLaunch;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public int getFirstStageEngines() {
        return firstStageEngines;
    }

    public void setFirstStageEngines(int firstStageEngines) {
        this.firstStageEngines = firstStageEngines;
    }

    public double getFirstStageFuel() {
        return firstStageFuel;
    }

    public void setFirstStageFuel(double firstStageFuel) {
        this.firstStageFuel = firstStageFuel;
    }

    public int getSecondStageEngines() {
        return secondStageEngines;
    }

    public void setSecondStageEngines(int secondStageEngines) {
        this.secondStageEngines = secondStageEngines;
    }

    public double getSecondStageFuel() {
        return secondStageFuel;
    }

    public void setSecondStageFuel(double secondStageFuel) {
        this.secondStageFuel = secondStageFuel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCostPerLaunch() {
        return costPerLaunch;
    }

    public void setCostPerLaunch(int costPerLaunch) {
        this.costPerLaunch = costPerLaunch;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
