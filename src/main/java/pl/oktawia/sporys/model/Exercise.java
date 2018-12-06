package pl.oktawia.sporys.model;

import lombok.Data;
import pl.oktawia.sporys.enums.Types;

import javax.persistence.*;



@NamedQueries(value = {
        @NamedQuery(name = Exercise.GET_BY_ID, query = "SELECT e FROM Exercise e WHERE e.type like :ID")
//        @NamedQuery(name = Exercise.GET_BY_CATEGORY_ID, query="SELECT e FROM Exercise e WHERE e.categoryId like :CATEGORY_ID")
})
@Entity
@Table(name = "EXERCISE")
@Data
public class Exercise  extends BaseEntity {

    public static final String GET_BY_ID = "getById";
    public static final String GET_BY_CATEGORY_ID = "getByCategoryID";
    public static final String GET_BY_RESULT_ID = "getByResultID";

    @Column(name = "TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Types type;

    @Column(name = "CONTENTS", nullable = false)
    private String contents;

    @Column(name = "MANTISE_ARG1", nullable = false)
    private String mantiseArg1;

    @Column(name = "CELLING_ARG1", nullable = false)
    private String cellingArg1;

    @Column(name = "MANTISE_ARG2", nullable = false)
    private String mantiseArg2;

    @Column(name = "CELLING_ARG2", nullable = false)
    private String cellingArg2;

    @Column(name = "BASE", nullable = false)
    private String base;

    @OneToOne
    @JoinColumn(name = "result_fk")
    private Result result;
}
