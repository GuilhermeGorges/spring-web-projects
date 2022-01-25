package com.guilherme.springapihateoas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guilherme.springapihateoas.controller.request.SoldierEditRequest;
import com.guilherme.springapihateoas.controller.response.SoldierListResponse;
import com.guilherme.springapihateoas.controller.response.SoldierResponse;
import com.guilherme.springapihateoas.dto.SoldierDTO;
import com.guilherme.springapihateoas.entity.SoldierEntity;
import com.guilherme.springapihateoas.repository.SoldierRepository;
import com.guilherme.springapihateoas.resource.SoldierResource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SoldierService {

    private SoldierRepository soldierRepository;
    private ObjectMapper objectMapper;
    private SoldierResource soldierResource;

    public List<SoldierListResponse> listAllSoldiers(){
        List<SoldierEntity> soldierEntityList = soldierRepository.findAll();
        List<SoldierListResponse> streamSoldierDTO = soldierEntityList.stream()
                .map(it -> soldierResource.createLink(it))
                .collect(Collectors.toList());
        return streamSoldierDTO;
    }

    public SoldierResponse findSoldier(Long id) {
        SoldierEntity soldierEntity = soldierRepository.findById(id).orElseThrow();
        SoldierResponse soldierResponse = objectMapper.convertValue(soldierEntity, SoldierResponse.class);
        return soldierResponse;
    }

    public void createSoldier(SoldierDTO soldierDTO){
        SoldierEntity soldierEntity = objectMapper.convertValue(soldierDTO, SoldierEntity.class);
        soldierRepository.save(soldierEntity);
    }

    public void updateSoldier(Long id, SoldierEditRequest soldadoEditRequest) {
        SoldierEntity soldierEntity = objectMapper.convertValue(soldadoEditRequest, SoldierEntity.class);
        //soldierEntity.setId(id);
        soldierRepository.save(soldierEntity);
    }

    public void deleteSoldier(Long id) {
        SoldierEntity soldierEntity = soldierRepository.findById(id).orElseThrow();
        soldierRepository.delete(soldierEntity);
    }
}

