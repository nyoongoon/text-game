package com.example.demo.domain.texts.choice.repository;

import com.example.demo.domain.texts.choice.entity.Choice;
import com.example.demo.domain.texts.content.entity.Content;
import com.example.demo.domain.texts.content.repository.ContentRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ChoiceRepositoryTest {
    @Autowired
    ContentRepository contentRepository;
    @Autowired
    ChoiceRepository choiceRepository;

    @Test
    @Transactional
    void 선택지로_콘텐트_찾기() {
        Content content1 = Content.builder()
                .detail("첫번째 콘텐트")
                .build();
        Content content2 = Content.builder()
                .detail("두번째 콘텐트")
                .build();
        Choice choice = Choice.builder().build();
        content1.updateContents(choice);
        choice.updateNextContent(content2);
        contentRepository.save(content1);


        Content foundContent = contentRepository.findById(content1.getId()).orElseThrow();
        Choice foundChoice = foundContent.getChoices().get(0);
        Content foundNextContent = foundChoice.getNextContent();

        assertThat(foundNextContent).isEqualTo(content2);
        assertThat(foundNextContent.getDetail()).isEqualTo("두번째 콘텐트");
    }
}