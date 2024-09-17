package com.dio.space.domain.repository;

import com.dio.space.domain.model.Rocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface RocketRepository extends JpaRepository<Rocket, String> {

    Rocket findByName(String name);
}
