package pl.oktawia.sporys.repository;


import org.springframework.data.repository.CrudRepository;
import pl.oktawia.sporys.enums.Types;
import pl.oktawia.sporys.model.Exercise;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

    Exercise findById(int id);
    Optional<List<Exercise>> findAllByType(Types type);
}
