package pl.oktawia.sporys.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    ResultRepository resultRepository;

    @Autowired
    ExerciseRepository exerciseRepository;

    private Random random = new Random();

    @Override
    public Exercise getById(Integer id) {
        return exerciseRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Cant find exercises by category with id" + id));
    }

    @Override
    public Exercise getByCategoryId(Types type) {
        return exerciseRepository.findByType(type)
                .orElseThrow(()->new IllegalArgumentException("Cant find exercises by type " + type.getName()));
    }

    @Override
    public List<Exercise> getAllExercisesByType(Types type) {
        Optional<List<Exercise>> exercises = exerciseRepository.findAllByType(type);
        return  exercises.orElseGet(() -> new ArrayList<>());
    }

    @Override
    public List<Exercise> getAll() {
        return exerciseRepository.getAllByIdNotNull()
                .orElseThrow(()->new IllegalArgumentException("No exercises in database"));
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

    @Override
    public void addExercise(Types type, String content, Double arg1M, Integer arg1C, Double arg2M,
                            Integer arg2C, Integer base, Result result) {
        Exercise exercise = new Exercise(type, content, arg1M,arg1C,arg2M,arg2C,base,result);
        //Exercise exercise = new Exercise(result);
        exerciseRepository.save(exercise);
        //exercise.

    }

}
