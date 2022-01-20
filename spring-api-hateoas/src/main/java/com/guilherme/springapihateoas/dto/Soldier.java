package com.guilherme.springapihateoas.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Soldier {

    private Long id;
    private String cpf;
    private String nome;
    private String raca;
    private String arma;
    private String status;
}
