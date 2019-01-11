package pl.oktawia.sporys.service;

import org.springframework.stereotype.Service;
import pl.oktawia.sporys.enums.Types;
import pl.oktawia.sporys.model.Exercise;
import pl.oktawia.sporys.model.Result;

import java.util.List;
@Service
public interface ExerciseService {

    Exercise getById(Integer id);
    Exercise getByCategoryId(Types type);
    List<Exercise> getAllExercisesByType(Types type);
    List<Exercise> getAll();
    Exercise getRandomExercise(List<Exercise> exercises);
    void addExercise(Types type, String content, Double arg1M, Integer arg1C, Double arg2M,
                     Integer arg2C, Integer base, Result result);
   //void addExercise(Result result);
}
