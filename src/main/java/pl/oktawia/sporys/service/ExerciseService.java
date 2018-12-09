package pl.oktawia.sporys.service;

import pl.oktawia.sporys.enums.Types;
import pl.oktawia.sporys.model.Exercise;
import pl.oktawia.sporys.model.Result;

import java.util.List;

public interface ExerciseService {

    Exercise getById(Integer id);
    Exercise getByCategoryId(Types type);
    Result getByResultId(Long resultId);
    List<Exercise> getAllExercisesByType(Types type);
    List<Exercise> getAll();
    Exercise getRandomExercise(List<Exercise> exercises);
    void addExercise(Result result);
}
