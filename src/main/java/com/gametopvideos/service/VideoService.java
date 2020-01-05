package com.gametopvideos.service;

import com.gametopvideos.GenericService;
import com.gametopvideos.dto.VideoDTO;
import com.gametopvideos.entity.Video;
import com.gametopvideos.repo.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService extends GenericService<Video, VideoDTO> {

    private VideoRepo videoRepo;

    @Autowired
    public VideoService(VideoRepo videoRepo) {
        this.videoRepo = videoRepo;
    }


    public List<VideoDTO> getVideos(){
        List<VideoDTO> videoDTOList = new ArrayList<>();
        List<Video> videoList = videoRepo.findAll();
        return toDTOList(videoList,videoDTOList);
    }

    public List<VideoDTO> getVideosByCategory(Long categoryId){
        List<VideoDTO> videoDTOList = new ArrayList<>();
        List<Video> videoList = videoRepo.findVideosByCategory_Id(categoryId);
        return toDTOList(videoList,videoDTOList);
    }

    public void saveVideo(VideoDTO videoDTO){
        Video video = toEntity(videoDTO,new Video());
        videoRepo.save(video);
    }
}
