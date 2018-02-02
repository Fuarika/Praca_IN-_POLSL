package pl.oktawia.sporys.dao;

import pl.oktawia.sporys.model.Exercise;

public interface ExerciseDao extends GenericDao<Exercise> {

    Exercise getByType(String type);
    Exercise getByCategoryId (Long categoryId);
}