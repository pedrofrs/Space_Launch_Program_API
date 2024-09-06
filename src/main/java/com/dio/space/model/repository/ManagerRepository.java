package com.dio.space.model.repository;

import com.dio.space.model.Manager;
import com.dio.space.service.CrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager,Long> {
}
