package com.example.demo.domain.texts.post.entity;

import com.example.demo.domain.texts.content.entity.Content;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToOne
    @JoinColumn(name = "CONTENT_ID")
    private Content firstContent;

    @Builder
    public Post(String title) {
        this.title = title;
    }

    public void updateFirstContent(Content firstContent) {
        this.firstContent = firstContent;
    }
}