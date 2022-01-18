package com.guilherme.springwebintermediaterestapi.controller;

import com.guilherme.springwebintermediaterestapi.dto.Soldier;
import com.guilherme.springwebintermediaterestapi.service.SoldierService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/soldier")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SoldierController {

    private SoldierService soldierService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Soldier> getAllSoldier(){
        return soldierService.getAllSoldier();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Soldier> getSoldierByID(@PathVariable("id") Long id){
        final Soldier soldier = soldierService.getSoldierByID(id);
        return ResponseEntity.ok(soldier);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Soldier crateSoldier(@RequestBody Soldier soldier){
        return soldierService.createSoldier(soldier);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Soldier> editSoldier(@PathVariable("id") Long id, @RequestBody Soldier dto){
        return ResponseEntity.ok(soldierService.updateSoldier(id, dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSoldier(@PathVariable("id")Long id){
        soldierService.deleteSoldier(id);
    }
}
