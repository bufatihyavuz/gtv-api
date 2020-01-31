package com.gametopvideos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class IdNameDTO {

    private Integer id;
    private String name;

    public IdNameDTO() {
    }

    public IdNameDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
