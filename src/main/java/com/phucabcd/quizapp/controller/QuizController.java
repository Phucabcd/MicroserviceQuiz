package com.phucabcd.quizapp.controller;

import com.phucabcd.quizapp.entity.QuestionWrapper;
import com.phucabcd.quizapp.entity.Quiz;
import com.phucabcd.quizapp.entity.response.ResponseQuiz;
import com.phucabcd.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            @RequestParam String category, @RequestParam int numQ,@RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);
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
