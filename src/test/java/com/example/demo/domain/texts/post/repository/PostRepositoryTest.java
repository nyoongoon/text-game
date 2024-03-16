package com.example.demo.domain.texts.post.repository;

import com.example.demo.domain.texts.content.entity.Content;
import com.example.demo.domain.texts.post.entity.Post;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
    @Transactional
    void 포스트_인서트(){
        Post post = Post.builder().build();
        Content firstContent = Content.builder()
                .detail("첫번째 컨텐트")
                .build();
        post.updateFirstContent(firstContent);
        postRepository.save(post);

        Post found = postRepository.findById(post.getId()).orElseThrow();
        assertThat(found.getFirstContent()).isEqualTo(firstContent);
    }
}