package com.gametopvideos.enums;

import lombok.Getter;

@Getter
public enum LOLHeroes {

    AHRI(1,"AHRI"),
    AKALI(2,"AKALI"),
    ZED(3,"ZED");

    private final Integer id;
    private final String name;

    LOLHeroes(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
