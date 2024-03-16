package com.example.demo.domain.texts.content.entity;

import com.example.demo.domain.texts.choice.entity.Choice;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTENT_ID")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHOICE_ID")
    List<Choice> choices = new ArrayList<>();

    private String detail;

    @Builder
    public Content(String detail) {
        this.detail = detail;
    }

    public void updateContents(Choice choice) {
        this.choices.add(choice);
    }

    // TODO 엔티티의 GETTER에는 서비스의 정책을 절대 넣지 말 것! -> 응답 클래스 분리
}