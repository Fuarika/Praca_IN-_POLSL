package pl.oktawia.sporys.repository;


import org.springframework.data.repository.CrudRepository;
import pl.oktawia.sporys.model.Exercise;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

    Exercise findById(int id);
}
