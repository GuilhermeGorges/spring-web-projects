package com.guilherme.springwebintermediaterestapi.service;

import com.guilherme.springwebintermediaterestapi.dto.Soldier;
import com.guilherme.springwebintermediaterestapi.repository.SoldierRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SoldierService {

    private SoldierRepository soldierRepository;

    public Soldier getSoldierByID(final Long id){
        return soldierRepository.getById(id);
    }

    public Soldier createSoldier(final Soldier soldier) {
        return soldierRepository.save(soldier);
    }
}
