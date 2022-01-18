package com.guilherme.springwebintermediaterestapi.service;

import com.guilherme.springwebintermediaterestapi.dto.Soldier;
import com.guilherme.springwebintermediaterestapi.exception.SoldierNotFoundException;
import com.guilherme.springwebintermediaterestapi.repository.SoldierRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SoldierService {

    private SoldierRepository soldierRepository;

    public Soldier getSoldierByID(final Long id){
        //return soldierRepository.getById(id);

        final Optional<Soldier> soldier = soldierRepository.findById(id);
        if(soldier.isPresent()){
            return soldier.get();
        } else {
            throw new SoldierNotFoundException();
        }
    }

    public Soldier createSoldier(final Soldier soldier) {
        return soldierRepository.save(soldier);
    }

    public List<Soldier> getAllSoldier() {
        return soldierRepository.findAll();
    }

    public Soldier updateSoldier(Long id, Soldier dto) {
        final Optional<Soldier> optionalSoldier = soldierRepository.findById(id);
        final Soldier soldier;

        if(optionalSoldier.isPresent()){
            soldier = optionalSoldier.get();
        } else {
            throw new SoldierNotFoundException();
        }
        soldier.setName(dto.getName());
        soldier.setBreed(dto.getBreed());
        soldier.setWeapon(dto.getWeapon());
        return soldierRepository.save(soldier);

    }

    public void deleteSoldier(Long id) {
        final Soldier soldier = getSoldierByID(id);
        soldierRepository.delete(soldier);
    }
}
