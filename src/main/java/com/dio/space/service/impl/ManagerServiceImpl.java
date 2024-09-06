package com.dio.space.service.impl;

import com.dio.space.domain.model.Manager;
import com.dio.space.domain.repository.ManagerRepository;
import com.dio.space.service.ManagerService;
import com.dio.space.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService {

    //Add exceptions

    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public List<Manager> findAll() {
        return managerRepository.findAll();
    }

    @Override
    public Manager findById(Long id) {
        return managerRepository.findById(id).get();
    }

    @Override
    public Manager create(Manager entity) {


        entity.setInsertionDate(LocalDateTime.now());
        managerRepository.save(entity);
        return null;
    }


    @Override
    public Manager update(Long id, Manager entity) {
        Optional<Manager> dbManager = managerRepository.findById(id);
        if (!dbManager.isEmpty()){
            managerRepository.save(entity);
        }

       return entity;
    }

    @Override
    public void delete(Long id) {
        Manager manager = managerRepository.findById(id).get();
        managerRepository.delete(manager);

    }


}