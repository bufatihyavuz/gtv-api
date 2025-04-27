package com.gametopvideos.repo;

import com.gametopvideos.dto.IVideoDTO;
import com.gametopvideos.dto.VideoDTO;
import com.gametopvideos.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepo extends JpaRepository<Video,Long> {

    List<Video> findVideosByCategory_Id(Long categoryId);

    @Query(value = "SELECT v FROM Video v")
    List<IVideoDTO> getAll();
}
