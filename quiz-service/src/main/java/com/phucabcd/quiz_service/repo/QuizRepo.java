package com.phucabcd.quiz_service.repo;

import com.phucabcd.quiz_service.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {
}
