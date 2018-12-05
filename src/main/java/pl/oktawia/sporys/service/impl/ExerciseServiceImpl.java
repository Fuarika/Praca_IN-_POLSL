package pl.oktawia.sporys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oktawia.sporys.dao.ExerciseDao;
import pl.oktawia.sporys.enums.Types;
import pl.oktawia.sporys.model.Exercise;
import pl.oktawia.sporys.service.ExerciseService;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    ExerciseDao exerciseDao;

    private Random random = new Random();

    @Override
    public Exercise getById(Integer id) {
        return exerciseDao.getById(id);
    }

    @Override
    public Exercise getByCategoryId(Long categoryId) {
        return exerciseDao.getByCategoryId(categoryId);
    }

    @Override
    public Exercise getByResultId(Integer resultId) {
        return exerciseDao.getByResultId(resultId);
    }

    @Override
    public List<Exercise> getAllExercisesByType(Types type) {
        List<Exercise> allExercises = exerciseDao.getAll(Exercise.class);
        return filterForType(type, allExercises);
                //getRandomExercise(filterForType(type, allExercises));
    }

    @Override
    public List<Exercise> getAll() {
        return exerciseDao.getAll(Exercise.class);
    }

    private List<Exercise> filterForType(Types type, List<Exercise> exercises) {
        List<Exercise> filtered = exercises.stream().filter(ex -> type.equals(ex.getType())).collect(Collectors.toList());
        return filtered;
    }

    @Override
    public Exercise getRandomExercise(List<Exercise> exercises) {
        Exercise ex = exercises.get(random.nextInt(exercises.size()));
        return ex;
    }

}
