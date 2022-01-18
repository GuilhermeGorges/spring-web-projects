package com.guilherme.springwebintermediaterestapi.controller;

import com.guilherme.springwebintermediaterestapi.dto.Soldier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/soldier")
public class SoldierController {

    @GetMapping
    public ResponseEntity<Soldier> getSoldier(){
        return ResponseEntity.ok().build();
    }

}
