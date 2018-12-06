package pl.oktawia.sporys.service.impl;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.oktawia.sporys.dao.ExerciseDao;
import pl.oktawia.sporys.enums.Types;
import pl.oktawia.sporys.model.Exercise;
import pl.oktawia.sporys.model.Result;
import pl.oktawia.sporys.repository.ExerciseRepository;
import pl.oktawia.sporys.repository.ResultRepository;
import pl.oktawia.sporys.service.ExerciseService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    ExerciseDao exerciseDao;

    @Autowired
    ResultRepository resultRepository;

    @Autowired
    ExerciseRepository exerciseRepository;

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
    public Result getByResultId(Long resultId) {
        return resultRepository.findById(resultId.longValue());
    }

    @Override
    public List<Exercise> getAllExercisesByType(Types type) {
        Optional<List<Exercise>> exercises = exerciseRepository.findAllByType(type);
        return  exercises.orElseGet(() -> new ArrayList<>());
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
