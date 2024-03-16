package com.example.demo.domain.texts.choice.entity;

import com.example.demo.domain.texts.content.entity.Content;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String detail;

    @ManyToOne
    @JoinColumn(name = "CONTENT_ID")
    private Content nextContent;

    @Builder
    public Choice(String detail) {
        this.detail = detail;
    }

    public void updateNextContent(Content nextContent) {
        this.nextContent = nextContent;
    }
}