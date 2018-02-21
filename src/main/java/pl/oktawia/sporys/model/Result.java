package pl.oktawia.sporys.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Oktawia Sporyś
 */

@Entity
@Table(name = "RESULT")
@Data
public class Result extends BaseEntity {

    //public static final Exercise GET_EXERCISE_ID = "getExerciseId";

    @Column(name = "ANSWER", nullable = false)
    private String answer;

}
