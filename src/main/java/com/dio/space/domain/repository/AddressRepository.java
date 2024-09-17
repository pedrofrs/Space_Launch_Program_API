package com.dio.space.domain.repository;

import com.dio.space.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    Address findByPostalCode(String postalCode);
}
