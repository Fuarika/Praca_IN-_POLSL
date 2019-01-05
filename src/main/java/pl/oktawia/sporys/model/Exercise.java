package pl.oktawia.sporys.model;

import lombok.Data;

import pl.oktawia.sporys.enums.Types;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "EXERCISE")
@Data
public class Exercise  extends BaseEntity {

    public static final String GET_BY_ID = "getById";
    public static final String GET_BY_CATEGORY_ID = "getByCategoryID";
    public static final String GET_BY_RESULT_ID = "getByResultID";

    private LocalDate creationDate;
    private LocalDate modiftDate;
    private Long id;
    private Long version;

    public Exercise(Types type, String content, Double arg1M, Integer arg1C, Double arg2M,
                    Integer arg2C, Integer base, Result result) {

        this.id = getId();
        setCreationDate(creationDate.now());
        setModiftDate(modiftDate.now());
        setVersion(Long.valueOf(1));

        this.type = type;
        this.contents = content;
        this.mantiseArg1 = arg1M;
        this.cellingArg1 = arg1C;
        this.mantiseArg2 = arg2M;
        this.cellingArg2 = arg2C;
        this.base = base;
        this.result = result;
    }
    public Exercise(Result result) {
        this.result = result;
    }

    public Exercise() {
    }

    @Column(name = "TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Wpisz jeden z rodzajów równań: ADDITION, SUBTRATION, MULTIPLICATION, DIVISION.")
    private Types type;

    @Column(name = "CONTENTS", nullable = false)
    private String contents;

    @Column(name = "MANTISE_ARG1", nullable = false)
    @NotNull(message = "Wartość manstsy X nie może być pusta.")
    @Digits(integer = 1, fraction = 2, message = "Zły format mantysy dla liczby X.")
    private Double mantiseArg1;

    @Column(name = "CELLING_ARG1", nullable = false)
    @NotNull (message = "Wartość cechy X nie może być pusta.")
    private Integer cellingArg1;

    @Column(name = "MANTISE_ARG2", nullable = false)
    @NotNull(message = "Wartość manstsy Y nie może być pusta.")
    @Digits(integer = 1, fraction = 2 , message = "Zły format mantysy dla liczby Y.")
    private Double mantiseArg2;

    @Column(name = "CELLING_ARG2", nullable = false)
    @NotNull(message = "Wartość cechy Y nie może być pusta.")
    private Integer cellingArg2;

    @Column(name = "BASE", nullable = false)
    private Integer base;

    @OneToOne
    @JoinColumn(name = "result_fk")
    private Result result;



}
