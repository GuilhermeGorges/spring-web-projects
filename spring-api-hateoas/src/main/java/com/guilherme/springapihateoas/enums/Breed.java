package com.guilherme.springapihateoas.enums;

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
}
