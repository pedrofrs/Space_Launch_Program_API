package com.dio.space.model.repository;

import com.dio.space.model.Address;
import com.dio.space.model.DTO.AddressDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
