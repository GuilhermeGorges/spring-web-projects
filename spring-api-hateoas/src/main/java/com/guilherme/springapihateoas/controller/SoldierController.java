package com.guilherme.springapihateoas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guilherme.springapihateoas.controller.request.SoldierEditRequest;
import com.guilherme.springapihateoas.controller.response.SoldierResponse;
import com.guilherme.springapihateoas.dto.Soldier;
import com.guilherme.springapihateoas.service.SoldierService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/soldier")
@AllArgsConstructor
public class SoldierController {

    private SoldierService soldierService;
    private ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<List<SoldierResponse>> listAllSoldier() {
        List<SoldierResponse> soldierResponseList = soldierService.listAllSoldiers().stream()
                .map(it -> objectMapper.convertValue(it, SoldierResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(soldierResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldierResponse> searchSoldier(@PathVariable() Long id) {
        SoldierResponse soldierResponse = soldierService.findSoldier(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldierResponse);
    }

    @PostMapping
    public ResponseEntity createSoldier(@RequestBody Soldier soldier) {
        soldierService.createSoldier(soldier);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSoldier(@PathVariable() Long id,
                                        @RequestBody Soldier soldier) {
        soldierService.updateSoldier(id, soldier);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSoldier(@PathVariable Long id) {
        soldierService.deleteSoldier(id);
        return ResponseEntity.ok().build();
    }

}
