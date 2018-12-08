package pl.oktawia.sporys.repository;

import org.springframework.data.repository.CrudRepository;
import pl.oktawia.sporys.model.Result;

public interface ResultRepository extends CrudRepository<Result, Long>{

    Result findById(Long id);
    Integer insertResult (String answer, String step1, String step2, String step3, String step4);
}
