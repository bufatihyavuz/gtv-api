package com.gametopvideos.dto;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class CategoryDTO {

    private Long id;
    private String name;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id) {
        this.id = id;
    }
}
