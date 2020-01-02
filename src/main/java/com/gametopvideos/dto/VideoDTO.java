package com.gametopvideos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VideoDTO {

    private Long id;
    private String title;
    private String url;
    private Long view;
    private Long duration;
    private Long size;
    private UserDTO user;
    private CategoryDTO category;
}
