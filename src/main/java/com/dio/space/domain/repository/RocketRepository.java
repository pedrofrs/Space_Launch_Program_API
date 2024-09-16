package com.dio.space.domain.repository;

import com.dio.space.domain.model.Rocket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RocketRepository extends JpaRepository<Rocket, String> {

    Rocket findByName(String name);
}
