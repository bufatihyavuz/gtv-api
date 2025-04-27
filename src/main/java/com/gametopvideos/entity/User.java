package com.gametopvideos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "GTVUSER",catalog = "gtv")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private BigInteger id;

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    private String name;

    @Basic
    @Column(name = "surname", nullable = true, length = 50)
    private String surname;

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    private String email;

    @Basic
    @Column(name = "status", nullable = true, length = 10)
    private String status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user",cascade = CascadeType.ALL)
    private List<Video> videos;

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "USER_ROLES",catalog = "gtv")
    private List<Role> roles;
}
