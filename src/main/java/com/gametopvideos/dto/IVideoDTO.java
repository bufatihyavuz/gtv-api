package com.gametopvideos.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;

public interface IVideoDTO {

    BigInteger getId();
    String getTitle();
    String getUrl();
    Long getView();
    String getDuration();
    Long getSize();
    LocalDateTime getCreateDate();
    IUserDTO getUser();
    ICategoryDTO getCategory();
}
