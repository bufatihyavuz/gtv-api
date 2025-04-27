package com.gametopvideos.controller;

import com.gametopvideos.dto.VideoDTO;
import com.gametopvideos.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gametopvideos.exception.IOException.*;

import java.io.IOException;
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
    public ResponseEntity getAllVideos(){
        return new ResponseEntity<>(videoService.getVideos(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getAllVideos(Pageable pageable){
        return new ResponseEntity<>(videoService.getVideosPageable(pageable), HttpStatus.OK);
    }

    @GetMapping("categories/{categoryId}")
    public ResponseEntity getVideosByCategory(@PathVariable Long categoryId){
        List<VideoDTO> videoDTOList = videoService.getVideosByCategory(categoryId);
        return new ResponseEntity<List<VideoDTO>>(videoDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveVideo(@RequestBody VideoDTO videoDTO) throws IOException, WrongParameters {
        videoService.saveVideo(videoDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/youtubeViews")
    public void youtubeViews() throws IOException {
        videoService.testyoutubeViews();

    }
}
