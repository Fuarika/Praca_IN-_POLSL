package pl.oktawia.sporys.service;

import pl.oktawia.sporys.enums.Types;
import pl.oktawia.sporys.model.Exercise;

import java.util.List;

public interface ExerciseService {

    Exercise getById(Integer id);
    Exercise getByCategoryId(Long categoryId);
    List<Exercise> getAllExercisesByType(Types type);
    List<Exercise> getAll();
    Exercise getRandomExercise(List<Exercise> exercises);
}
