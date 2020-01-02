package com.gametopvideos.controller;

import com.gametopvideos.dto.VideoDTO;
import com.gametopvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    private VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }


    @GetMapping("")
    public ResponseEntity getVideos(){
        return new ResponseEntity<List<VideoDTO>>(videoService.getVideos(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity saveVideo(@RequestBody VideoDTO videoDTO){
        videoService.saveVideo(videoDTO);
        return new ResponseEntity(HttpStatus.OK);
    }
}
