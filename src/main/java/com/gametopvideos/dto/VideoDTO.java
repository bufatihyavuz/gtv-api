package com.gametopvideos.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class VideoDTO {

    private Long id;
    private String title;
    private String url;
    private Long view;
    private String duration;
    private Long size;
    private LocalDateTime createDate;
    private UserDTO user;
    private CategoryDTO category;
    private List<VideoTagDTO> videoTagDTOList;
    private List<String> videoTagList;
}
