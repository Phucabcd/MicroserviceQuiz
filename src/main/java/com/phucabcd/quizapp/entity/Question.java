package com.phucabcd.quizapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Question {
    @Id
    Integer id;
    String category;
    String difficultylevel;
    String option1;
    String option2;
    String option3;
    String questionTitle;
    String rightAnswer;

}
