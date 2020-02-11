package com.gametopvideos.repo;

import com.gametopvideos.entity.VideoTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VideoTagRepo extends JpaRepository<VideoTag,Long> {
}
