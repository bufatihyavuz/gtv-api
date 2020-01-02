package com.gametopvideos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserDTO {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String status;
    private List<VideoDTO> videos;
    private List<RoleDTO> roles;
}
