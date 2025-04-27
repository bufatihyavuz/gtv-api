package com.gametopvideos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "VIDEO_TAG",catalog = "gtv")
@Getter @Setter
public class VideoTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "tag", nullable = true, length = 100)
    private String tag;

/*    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "video_tag_video",  // İlişkiyi tutacak tablo
            joinColumns = @JoinColumn(name = "video_tag_id"),  // Student tablosunun foreign key
            inverseJoinColumns = @JoinColumn(name = "video_id")  // Course tablosunun foreign key
    )
    private List<Video> videos;*/

    @JsonIgnore
    @ManyToMany(mappedBy = "videoTagList")  // VideoTag ile ilişkili Video'lar
    private List<Video> videos;


}
