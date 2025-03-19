package com.phucabcd.quiz_service.entity.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuizDTO {
    String categoryName;
    Integer numQuestions;
    String title;;
}
