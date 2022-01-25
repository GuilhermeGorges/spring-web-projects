package com.guilherme.springapihateoas.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.guilherme.springapihateoas.controller.SoldierController;
import com.guilherme.springapihateoas.controller.response.SoldierListResponse;
import com.guilherme.springapihateoas.controller.response.SoldierResponse;
import com.guilherme.springapihateoas.entity.SoldierEntity;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Component
public class SoldierResource {

    private ObjectMapper objectMapper;

    public SoldierResource(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public SoldierListResponse createLink(SoldierEntity soldierEntity){
        SoldierListResponse soldierListResponse = objectMapper.convertValue(soldierEntity, SoldierListResponse.class);
        Link link = linkTo(methodOn(SoldierController.class).searchSoldier(soldierEntity.getId())).withSelfRel();
        soldierListResponse.add(link);
        return soldierListResponse;
    }

    public SoldierResponse createLinkDetail(SoldierEntity soldierEntity){
        SoldierResponse soldierListResponse = objectMapper.convertValue(soldierEntity, SoldierResponse.class);
        if(soldierEntity.getStatus().equals("morto")){
            Link link = linkTo(methodOn(SoldierController.class).deleteSoldier(soldierEntity.getId()))
                    .withRel("remove")
                    .withTitle("Delete soldier")
                    .withType("delete");
            soldierListResponse.add(link);
        } else if(soldierEntity.getStatus().equals("vivo")){
            Link link = linkTo(methodOn(SoldierController.class).frontCastle(soldierEntity.getId()))
                    .withRel("battle")
                    .withTitle("Go to the front of the castle")
                    .withType("put");
            soldierListResponse.add(link);
        }
        return soldierListResponse;
    }
}
