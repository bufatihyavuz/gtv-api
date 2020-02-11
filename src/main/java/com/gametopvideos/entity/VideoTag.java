package com.gametopvideos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "VIDEOTAG",schema = "gametopvideos",catalog = "gtv")
@Getter @Setter
public class VideoTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "tag", nullable = true, length = 100)
    private String tag;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Video video;


}
