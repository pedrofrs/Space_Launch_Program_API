package com.dio.space.domain.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(name = "description", length = 600, nullable = false)
    private String description;

    private LocalDateTime missionData;

    private boolean sucess;

    @ManyToOne
    @JoinColumn(name = "rocket_id", nullable = false )
    private Rocket rocket;

    @ManyToOne
    @JoinColumn(name = "payload_id", nullable = false)
    private Payload payload;
    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getMissionData() {
        return missionData;
    }

    public void setMissionData(LocalDateTime missionData) {
        this.missionData = missionData;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
