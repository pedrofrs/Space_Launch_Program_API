package com.dio.space.domain.repository;

import com.dio.space.domain.model.Payload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayloadRepository extends JpaRepository<Payload, Long> {
    Payload findByName(String name);
}
