package com.gametopvideos.service;

import com.gametopvideos.base.AbstractService;
import com.gametopvideos.base.YotubeUtil;
import com.gametopvideos.dto.VideoDTO;
import com.gametopvideos.dto.generics.youtubeAPI.ContentDetails;
import com.gametopvideos.dto.generics.youtubeAPI.Snippet;
import com.gametopvideos.dto.generics.youtubeAPI.Statistics;
import com.gametopvideos.dto.generics.youtubeAPI.YtVideoDTO;
import com.gametopvideos.entity.Video;
import com.gametopvideos.repo.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.gametopvideos.exception.IOException.*;

import javax.xml.ws.Response;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService extends AbstractService<Video, VideoDTO> {

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
        return (List<VideoDTO>)toDTOList(videoList,videoDTOList);
    }

    public void saveVideo(VideoDTO videoDTO) throws IOException, WrongParameters {
        VideoDTO finalVideoDTO = fillVideoDTOByYoutubeApi(videoDTO);
        Video video = toEntity(finalVideoDTO,new Video());
        videoRepo.save(video);
    }

    private VideoDTO fillVideoDTOByYoutubeApi(VideoDTO videoDTO) throws WrongParameters, IOException {
        String videoId = "";
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
