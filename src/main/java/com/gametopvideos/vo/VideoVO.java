package com.gametopvideos.vo;

import com.gametopvideos.dto.CategoryDTO;
import com.gametopvideos.dto.UserDTO;
import com.gametopvideos.dto.VideoTagDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class VideoVO {

    private BigInteger id;
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
