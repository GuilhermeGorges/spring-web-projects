package com.guilherme.springapihateoas.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guilherme.springapihateoas.controller.SoldierController;
import com.guilherme.springapihateoas.controller.response.SoldierListResponse;
import com.guilherme.springapihateoas.entity.SoldierEntity;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Component
@AllArgsConstructor
public class SoldierResource {

    private ObjectMapper objectMapper;

    public SoldierListResponse createLink(SoldierEntity soldierEntity){
        SoldierListResponse soldierListResponse = objectMapper.convertValue(soldierEntity, SoldierListResponse.class);
        Link link = linkTo(methodOn(SoldierController.class).searchSoldier(soldierEntity.getId())).withSelfRel();
        soldierListResponse.add(link);
        return soldierListResponse;
    }
}
