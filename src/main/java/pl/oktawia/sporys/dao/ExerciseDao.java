package pl.oktawia.sporys.dao;

import pl.oktawia.sporys.model.Exercise;

public interface ExerciseDao extends GenericDao<Exercise> {

    Exercise getById(Integer id);
    Exercise getByCategoryId (Long categoryId);
}