package com.phucabcd.quiz_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuestionWrapper {
    @Id
    Integer id;
    String questionTitle;
    String option1;
    String option2;
    String option3;

}
