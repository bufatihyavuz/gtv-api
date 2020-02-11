package com.gametopvideos.controller;

import com.gametopvideos.service.VideoService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Assertions.*;

/*@RunWith(SpringRunner.class)*/
@ExtendWith(SpringExtension.class)
@WebMvcTest(VideoController.class)
public class VideoControllerTest {

    //Rest apimize istekler yapacağımız mockito bağımlılığımızı çağırıyoruz
    @Autowired
    private MockMvc mockMvc;

    //VideoController'ın beslendiği servisimizi burada tanımlıyoruz.
    @MockBean
    private VideoService videoService;

    public void getAllVideosTest(){

    }
}
