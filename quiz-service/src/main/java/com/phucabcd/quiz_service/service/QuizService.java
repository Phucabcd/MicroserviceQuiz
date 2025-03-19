package com.phucabcd.quiz_service.service;

import com.phucabcd.quiz_service.entity.QuestionWrapper;
import com.phucabcd.quiz_service.entity.Quiz;
import com.phucabcd.quiz_service.entity.response.ResponseQuiz;
//import com.phucabcd.quiz_service.repo.QuestionRepo;
import com.phucabcd.quiz_service.feign.QuizFeign;
import com.phucabcd.quiz_service.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuizFeign quizFeign;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Integer> questions = quizFeign.generateQuestionsForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Succes", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizById(Integer id) {
//        Optional<Quiz> quiz = quizRepo.findById(id);
//        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
//        for (Question q : questionsFromDB) {
//            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3());
//            questionForUser.add(qw);
//        }

        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(Integer id, List<ResponseQuiz> responses) {
//        Quiz quiz = quizRepo.findById(id).get();
//        List<Question> questions = quiz.getQuestions();
        int right = 0;
//        int i = 0;
//        for (ResponseQuiz r : responses) {
//            if(r.getResponse().equals(questions.get(i).getRightAnswer()))
//                right++;
//
//            i++;
//        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
