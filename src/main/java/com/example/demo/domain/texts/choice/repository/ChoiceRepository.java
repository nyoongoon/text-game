package com.example.demo.domain.texts.choice.repository;

import com.example.demo.domain.texts.choice.entity.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {
}

