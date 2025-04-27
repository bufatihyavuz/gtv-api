package com.gametopvideos.service;

import com.gametopvideos.base.AbstractService;
import com.gametopvideos.base.YotubeUtil;
import com.gametopvideos.dto.IVideoDTO;
import com.gametopvideos.dto.VideoDTO;
import com.gametopvideos.dto.VideoTagDTO;
import com.gametopvideos.dto.generics.youtubeAPI.ContentDetails;
import com.gametopvideos.dto.generics.youtubeAPI.Snippet;
import com.gametopvideos.dto.generics.youtubeAPI.Statistics;
import com.gametopvideos.dto.generics.youtubeAPI.YtVideoDTO;
import com.gametopvideos.entity.Video;
import com.gametopvideos.entity.VideoTag;
import com.gametopvideos.repo.VideoRepo;
import com.gametopvideos.repo.VideoTagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.gametopvideos.exception.IOException.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class VideoService extends AbstractService<Video, VideoDTO> {

    private VideoRepo videoRepo;
    private VideoTagRepo videoTagRepo;

    @Autowired
    public VideoService(VideoRepo videoRepo, VideoTagRepo videoTagRepo) {
        this.videoRepo = videoRepo;
        this.videoTagRepo = videoTagRepo;
    }


    public List<IVideoDTO> getVideos(){
        return  videoRepo.getAll();
    }

    public List<VideoDTO> getVideosPageable(Pageable pageable){
        List<VideoDTO> videoDTOList = new ArrayList<>();
        Page<Video> videoList = videoRepo.findAll(pageable);
        return toDTOList(videoList.toList(),videoDTOList);
    }

    public List<VideoDTO> getVideosByCategory(Long categoryId){
        List<VideoDTO> videoDTOList = new ArrayList<>();
        List<Video> videoList = videoRepo.findVideosByCategory_Id(categoryId);
        return (List<VideoDTO>)toDTOList(videoList,videoDTOList);
    }

    public void saveVideo(VideoDTO videoDTO) throws IOException, WrongParameters {
        List<VideoTag> videoTagList = new ArrayList<>();
        VideoDTO finalVideoDTO = fillVideoDTOByYoutubeApi(videoDTO);
        Video video = toEntity(finalVideoDTO,new Video());
        Video savedVideo = videoRepo.save(video);

        for (String tag : finalVideoDTO.getVideoTagList()){
            VideoTag videoTag = new VideoTag();
            videoTag.setTag(tag);
            videoTag.setVideos(Collections.singletonList(savedVideo));
            videoTagList.add(videoTag);
        }
        videoTagRepo.saveAll(videoTagList);
    }

    private VideoDTO fillVideoDTOByYoutubeApi(VideoDTO videoDTO) throws WrongParameters, IOException {
        String videoId = "";
        List<VideoTagDTO> videoTagDTOList = new ArrayList<>();
        if(videoDTO == null ||  videoDTO.getUrl().isEmpty()){
            throw new WrongParameters("WrongParameters Exception");
        }

        String requestURL = YotubeUtil.generateYoutubeApiRequestURL(videoDTO.getUrl(),"snippet,statistics,contentDetails");
        ResponseEntity<YtVideoDTO> ytVideoDTO = callYoutubeAPI(requestURL);

        ContentDetails contentDetails = ytVideoDTO.getBody().getItems().get(0).getContentDetails();
        Snippet snippet = ytVideoDTO.getBody().getItems().get(0).getSnippet();
        Statistics statistics = ytVideoDTO.getBody().getItems().get(0).getStatistics();

        videoDTO.setTitle(snippet.getTitle());
        videoDTO.setView(Long.valueOf(statistics.getViewCount()));
        videoDTO.setDuration(contentDetails.getDuration());
        DateTimeFormatter f = DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.systemDefault());
        videoDTO.setCreateDate(LocalDateTime.parse(snippet.getPublishedAt(), f));

        videoDTO.setVideoTagList(snippet.getTags());
        return videoDTO;
    }

    private ResponseEntity<YtVideoDTO> callYoutubeAPI(String requestURL) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<YtVideoDTO> ytVideoDTO = restTemplate
                .getForEntity(requestURL, YtVideoDTO.class);
        return ytVideoDTO;
    }


    public ResponseEntity<YtVideoDTO> testyoutubeViews() throws IOException {
        String requestURL = YotubeUtil.generateYoutubeApiRequestURL("LjkOp5CO0zw","snippet,statistics,contentDetails");
        return callYoutubeAPI(requestURL);
    }

}
