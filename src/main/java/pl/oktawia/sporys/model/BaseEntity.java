package pl.oktawia.sporys.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name = "CREATION_DATE")
    private LocalDate creationDate;

    @Column(name = "MODIFY_DATE")
    private LocalDate modiftDate;

    @Version
    @Column(name = "VERSION")
    private Long version;
}
