package com.example.demo.domain.texts.content.repository;

import com.example.demo.domain.texts.content.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
