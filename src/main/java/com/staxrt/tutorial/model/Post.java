package com.staxrt.tutorial.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="post")
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="content")
    private String content;

    @Builder
    public Post(String content){
        this.content = content;
    }
}
