package com.gametopvideos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "VIDEO",schema = "gametopvideos",catalog = "gtv")
@Getter @Setter
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "title", nullable = true, length = 200)
    private String title;

    @Basic
    @Column(name = "url", nullable = true, length = 200)
    private String url;

    @Basic
    @Column(name = "view", nullable = true, length = 20)
    private Long view;

    @Basic
    @Column(name = "duration", nullable = true, length = 20)
    private Long duration;

    @Basic
    @Column(name = "size", nullable = true, length = 20)
    private Long size;

    @Basic
    @Column(name = "create_date", nullable = true)
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}
