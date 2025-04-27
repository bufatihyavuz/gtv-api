package com.gametopvideos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "VIDEO",catalog = "gtv")
@Getter @Setter
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private BigInteger id;

    @Basic
    @Column(name = "title", length = 200)
    private String title;

    @Basic
    @Column(name = "url", length = 200)
    private String url;

    @Basic
    @Column(name = "view", length = 20)
    private Long view;

    @Basic
    @Column(name = "duration", length = 20)
    private String duration;

    @Basic
    @Column(name = "size", length = 20)
    private Long size;

    @Basic
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

/*    @ManyToMany(mappedBy = "videos")
    private List<VideoTag> videoTag;*/

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "video_tag_video",  // Bağlantı tablosu adı
            joinColumns = @JoinColumn(name = "video_id"),  // Video'nun foreign key'i
            inverseJoinColumns = @JoinColumn(name = "video_tag_id")  // VideoTag'in foreign key'i
    )
    private List<VideoTag> videoTagList;
}
