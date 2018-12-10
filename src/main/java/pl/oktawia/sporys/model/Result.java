package pl.oktawia.sporys.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "RESULT")
@Data
public class Result extends BaseEntity {

    private LocalDate creationDate;
    private LocalDate modiftDate;
    private Long id;
    private Long version;

    public Result(String answer, String step_1, String step_2, String step_3, String step_4) {

        this.id = getId();
        setCreationDate(creationDate.now());
        setModiftDate(modiftDate.now());
        setVersion(Long.valueOf(1));

        this.answer = answer;
        this.step_1 = step_1;
        this.step_2 = step_2;
        this.step_3 = step_3;
        this.step_4 = step_4;
    }
    public Result(String answer) {
        this.id = getId();
        this.creationDate = getCreationDate();
        this.modiftDate = getModiftDate();
        this.version = getVersion();

        this.answer = answer;

    }
    public Result(){}

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
