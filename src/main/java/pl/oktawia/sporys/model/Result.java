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

    @Column(name = "STEP_1", nullable = false)
    private String step_1;

    @Column(name = "STEP_2", nullable = false)
    private String step_2;

    @Column(name = "STEP_3", nullable = false)
    private String step_3;

    @Column(name = "STEP_4", nullable = false)
    private String step_4;

}
