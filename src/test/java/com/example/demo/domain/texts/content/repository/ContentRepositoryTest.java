package com.example.demo.domain.texts.content.repository;

import com.example.demo.domain.texts.choice.entity.Choice;
import com.example.demo.domain.texts.content.entity.Content;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ContentRepositoryTest {
    @Autowired
    ContentRepository contentRepository;

    @Test
    void 콘텐트_인서트() {
        Content content = Content.builder()
                .detail("첫번째 콘텐트")
                .build();
        int choicesCnt = 4;
        for (int i = 0; i < choicesCnt; i++) {
            Choice choice = Choice.builder().build();
            content.updateContents(choice);
        }
        contentRepository.save(content);

        Content found = contentRepository.findById(content.getId()).orElseThrow();
        assertThat(found.getChoices().size()).isEqualTo(choicesCnt);
    }
}