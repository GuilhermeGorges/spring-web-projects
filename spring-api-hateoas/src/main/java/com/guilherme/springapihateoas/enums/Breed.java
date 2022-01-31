package com.guilherme.springapihateoas.enums;

import java.util.stream.Stream;

public enum Breed {
    HOBBIT("hobbit"),
    MAGE("mage"),
    SORCERER("sorcerer"),
    ELF("elf"),
    FAIRY("fairy"),
    HUMAN("human"),
    ORC("orc"),
    DWARF("dwarf");

    private String value;

    Breed(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static Breed of(String value){
        return Stream.of(Breed.values())
                .filter(it -> it.getValue().equals(value))
                .findFirst()
                .orElseThrow();
    }
}


