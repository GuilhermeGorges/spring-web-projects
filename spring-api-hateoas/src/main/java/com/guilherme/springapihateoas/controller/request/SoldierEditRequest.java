package com.guilherme.springapihateoas.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SoldierEditRequest {
    private String name;
    private String breed;
    private String weapon;
    private String status;
}
