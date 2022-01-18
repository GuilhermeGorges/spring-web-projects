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

    @GetMapping("/{id}")
    public ResponseEntity<Soldier> getSoldierByID(@PathVariable("id") Long id){
        final Soldier soldier = soldierService.getSoldierByID(id);
        return ResponseEntity.ok(soldier);
    }

    

}
