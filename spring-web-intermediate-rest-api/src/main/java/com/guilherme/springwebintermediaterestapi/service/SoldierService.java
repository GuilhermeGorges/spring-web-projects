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

    public Soldier getSoldierByID(Long id){
        Soldier soldier = new Soldier();
        soldier.setName("João");
        soldier.setWeapon("Knife");
        soldier.setBreed("Warrior");
        return soldier;
    }
}
