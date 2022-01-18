package com.guilherme.springwebintermediaterestapi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Soldier {
    private Long id;
    private String name;
    private String breed;
    private String weapon;
}
