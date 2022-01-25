package com.guilherme.springapihateoas.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guilherme.springapihateoas.controller.request.SoldierEditRequest;
import com.guilherme.springapihateoas.controller.response.SoldierListResponse;
import com.guilherme.springapihateoas.controller.response.SoldierResponse;
import com.guilherme.springapihateoas.dto.SoldierDTO;
import com.guilherme.springapihateoas.service.SoldierService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/soldier")
@AllArgsConstructor
public class SoldierController {

    private SoldierService soldierService;
    private ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<List<SoldierListResponse>> listAllSoldier() {
        List<SoldierListResponse> soldierListResponses = soldierService.listAllSoldiers();
        return ResponseEntity.status(HttpStatus.OK).body(soldierListResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoldierResponse> searchSoldier(@PathVariable Long id) {
        SoldierResponse soldierResponse = soldierService.findSoldier(id);
        return ResponseEntity.status(HttpStatus.OK).body(soldierResponse);
    }

    @PostMapping
    public ResponseEntity createSoldier(@RequestBody SoldierDTO soldierDTO) {
        soldierService.createSoldier(soldierDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateSoldier(@PathVariable Long id,
                                        @RequestBody SoldierEditRequest soldierEditRequest) {
        soldierService.updateSoldier(id, soldierEditRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSoldier(@PathVariable Long id) {
        soldierService.deleteSoldier(id);
        return ResponseEntity.ok().build();
    }

}
