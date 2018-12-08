package pl.oktawia.sporys.repository;

import org.springframework.data.repository.CrudRepository;
import pl.oktawia.sporys.model.Result;

public interface ResultRepository extends CrudRepository<Result, Long>{

    Result findById(Long id);
    Integer insertResult ();
}
