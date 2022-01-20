package com.guilherme.springapihateoas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guilherme.springapihateoas.controller.request.SoldierEditRequest;
import com.guilherme.springapihateoas.controller.response.SoldierResponse;
import com.guilherme.springapihateoas.dto.Soldier;
import com.guilherme.springapihateoas.entity.SoldierEntity;
import com.guilherme.springapihateoas.repository.SoldierRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SoldierService {

    private SoldierRepository soldierRepository;
    private ObjectMapper objectMapper;

    public List<Soldier> listAllSoldiers(){
        List<SoldierEntity> soldierEntityList = soldierRepository.findAll();
        List<Soldier> streamSoldier = soldierEntityList.stream()
                .map(it -> objectMapper.convertValue(it, Soldier.class))
                .collect(Collectors.toList());
        return streamSoldier;
    }

    public SoldierResponse findSoldier(Long id) {
        SoldierEntity soldierEntity = soldierRepository.findById(id).orElseThrow();
        SoldierResponse soldierResponse = objectMapper.convertValue(soldierEntity, SoldierResponse.class);
        return soldierResponse;
    }

    public void createSoldier(Soldier soldier){
        SoldierEntity soldierEntity = objectMapper.convertValue(soldier, SoldierEntity.class);
        soldierRepository.save(soldierEntity);
    }

    public void updateSoldier(Long id, SoldierEditRequest soldierEditRequest) {
        /*final Optional<SoldierEntity> optionalSoldier  = soldierRepository.findById(id);
        final SoldierEntity soldierEntity;

        if(optionalSoldier.isPresent()){
            soldierEntity = optionalSoldier.get();
        } else {
            throw new EmptyStackException();
        }
        soldierEntity.setName(soldierEditRequest.getName());
        soldierEntity.setBreed(soldierEditRequest.getBreed());
        soldierEntity.setStatus(soldierEditRequest.getStatus());
        soldierEntity.setWeapon(soldierEntity.getWeapon());

        soldierRepository.save(soldierEntity);*/
    }

    public void deleteSoldier(Long id) {
        SoldierEntity soldierEntity = soldierRepository.findById(id).orElseThrow();
        soldierRepository.delete(soldierEntity);
    }
}

