package com.gametopvideos.repo;

import com.gametopvideos.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepo extends JpaRepository<Video,Long> {

    List<Video> findVideosByCategory_Id(Long categoryId);
}
