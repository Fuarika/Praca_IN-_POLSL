package pl.oktawia.sporys.model;

import lombok.Data;

import javax.persistence.*;


//@NamedQueries({
//    @NamedQuery( name = Result.GET_EXERCISE_ID , query = "SELECT e FROM Result e WHERE e.exerciseId like :EXERCISE_ID")})
@Entity
@Table(name = "RESULT")
@Data
public class Result extends BaseEntity {

    //public static final Exercise GET_EXERCISE_ID = "getExerciseId";

    @Column(name = "ANSWER", nullable = false)
    private String answer;

    @OneToOne
    @JoinColumn(name = "EXERCISE_ID")
    private Exercise exerciseId;
}
