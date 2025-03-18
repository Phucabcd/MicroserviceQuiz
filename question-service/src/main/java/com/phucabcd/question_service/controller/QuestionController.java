package com.phucabcd.question_service.controller;

import com.phucabcd.question_service.entity.Question;
import com.phucabcd.question_service.entity.QuestionWrapper;
import com.phucabcd.question_service.entity.response.ResponseQuiz;
import com.phucabcd.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("category") String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
         return questionService.addQuestion(question);
    }

    @GetMapping("{id}")
    public Question getQuestionById(@PathVariable("id") int id) {
        return questionService.getQuestionId(id);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> generateQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numQuestions) {
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds) {
        return questionService.getQuestionFromId(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<ResponseQuiz> responses) {
        return questionService.getCore(responses);
    }

    // generate
    // getQuestions
    // getScore
}
