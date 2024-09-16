package com.dio.space.service.impl;

import com.dio.space.controller.dto.ManagerDto;
import com.dio.space.controller.dto.AddressDto;
import com.dio.space.domain.model.Address;
import com.dio.space.domain.model.Manager;
import com.dio.space.domain.model.ManagerAddresses;
import com.dio.space.domain.repository.AddressRepository;
import com.dio.space.domain.repository.ManagerAddressesRepository;
import com.dio.space.domain.repository.ManagerRepository;
import com.dio.space.service.ManagerService;
import com.dio.space.service.api.ViaCepService;
import com.dio.space.service.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ManagerAddressesRepository managerAddressesRepository;
    @Autowired
    private AddressRepository addressRepository;;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public List<ManagerDto> findAll() {
        return managerRepository.findAll().stream()
                .map(ManagerDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public ManagerDto findById(Long id) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Manager not found with id: " + id));
        return new ManagerDto(manager);
    }

    @Override
    public ManagerDto create(ManagerDto managerDto) {

        Manager manager = managerDto.toManager();
        manager.setInsertionDate(LocalDateTime.now());

        manager = managerRepository.save(manager);

        List<AddressDto> addressResponseList = new ArrayList<>();

        for (AddressDto managerCep : managerDto.addresses()) {
            Address address = viaCepService.getCep(managerCep.postalCode()).toAddress();
            Address existingAddress = addressRepository.findByPostalCode(address.getPostalCode());

            if (existingAddress == null) {
                addressRepository.save(address);
                existingAddress = address;
            }

            ManagerAddresses managerAddresses = new ManagerAddresses();
            managerAddresses.setManager(manager);
            managerAddresses.setAddress(existingAddress);
            managerAddressesRepository.save(managerAddresses);

            AddressDto addressDto = new AddressDto(existingAddress);
            addressResponseList.add(addressDto);
        }

        ManagerDto managerDtoResponse = new ManagerDto(
                manager.getFirstName(),
                manager.getLastName(),
                manager.getEmail(),
                manager.getAge(),
                manager.getCredential(),
                addressResponseList
        );

        return managerDtoResponse;
    }

    @Override
    public ManagerDto update(Long id, ManagerDto managerDto) {

        Manager existingManager = managerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Manager not found with id: " + id));

        existingManager.setFirstName(managerDto.firstName());
        existingManager.setLastName(managerDto.lastName());
        existingManager.setEmail(managerDto.email());
        existingManager.setAge(managerDto.age());
        existingManager.setCredential(managerDto.credential());

        managerRepository.save(existingManager);

        List<AddressDto> addressResponseList = new ArrayList<>();

        for (AddressDto managerCep : managerDto.addresses()) {
            Address address = viaCepService.getCep(managerCep.postalCode()).toAddress();
            Address existingAddress = addressRepository.findByPostalCode(address.getPostalCode());

            if (existingAddress == null) {
                addressRepository.save(address);
                existingAddress = address;
            }

            ManagerAddresses managerAddresses = managerAddressesRepository.findByManagerAndAddress(existingManager, existingAddress);
            if (managerAddresses == null) {
                managerAddresses = new ManagerAddresses();
                managerAddresses.setManager(existingManager);
                managerAddresses.setAddress(existingAddress);
                managerAddressesRepository.save(managerAddresses);
            }

            AddressDto addressDto = new AddressDto(existingAddress);
            addressResponseList.add(addressDto);
        }

        return new ManagerDto(
                existingManager.getFirstName(),
                existingManager.getLastName(),
                existingManager.getEmail(),
                existingManager.getAge(),
                existingManager.getCredential(),
                addressResponseList
        );
    }

    @Override
    public void delete(Long id) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Manager not found with id: " + id));
        managerRepository.delete(manager);


    }


}