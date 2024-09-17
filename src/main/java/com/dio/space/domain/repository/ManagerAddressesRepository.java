package com.dio.space.domain.repository;

import com.dio.space.domain.model.Address;
import com.dio.space.domain.model.Manager;
import com.dio.space.domain.model.ManagerAddresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ManagerAddressesRepository extends JpaRepository<ManagerAddresses, Long> {
    ManagerAddresses findByManagerAndAddress(Manager manager, Address address);
}
