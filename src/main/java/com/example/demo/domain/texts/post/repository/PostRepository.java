package com.example.demo.domain.texts.post.repository;

import com.example.demo.domain.texts.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
