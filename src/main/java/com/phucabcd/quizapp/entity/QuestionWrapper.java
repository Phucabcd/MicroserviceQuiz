package com.phucabcd.quizapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class QuestionWrapper {
    @Id
    Integer id;
    String questionTitle;
    String option1;
    String option2;
    String option3;

}
