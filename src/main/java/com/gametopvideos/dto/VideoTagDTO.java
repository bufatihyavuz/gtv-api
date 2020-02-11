package com.gametopvideos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VideoTagDTO {

    private Long id;
    private String tag;
    private VideoDTO videoDTO;
}
