package com.phucabcd.quiz_service.controller;

import com.phucabcd.quiz_service.entity.DTO.QuizDTO;
import com.phucabcd.quiz_service.entity.QuestionWrapper;
import com.phucabcd.quiz_service.entity.response.ResponseQuiz;
import com.phucabcd.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> create(
            @RequestBody QuizDTO quizDTO) {
        return quizService.createQuiz(quizDTO.getCategoryName(), quizDTO.getNumQuestions(), quizDTO.getTitle());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizId(@PathVariable Integer id) {
        return quizService.getQuizById(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<ResponseQuiz> responses) {
        return quizService.submitQuiz(id, responses);
    }

}
