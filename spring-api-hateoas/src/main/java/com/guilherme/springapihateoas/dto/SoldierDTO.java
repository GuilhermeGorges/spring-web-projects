package com.guilherme.springapihateoas.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SoldierDTO {

    private Long id;
    private String name;
    private String breed;
    private String weapon;
    private String status;

}
