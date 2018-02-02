package pl.oktawia.sporys.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import pl.oktawia.sporys.dao.ExerciseDao;
import pl.oktawia.sporys.model.Exercise;

@Component
public class ExerciseDaoImpl extends GenericDaoImpl<Exercise> implements ExerciseDao {

    @Override
    public Exercise getByType(String type) {
        Query query = session.openSession().getNamedQuery(Exercise.GET_BY_TYPE)
                .setParameter("CATEGORY_ID", type);
        Exercise exercise = (Exercise) query.uniqueResult();
        return exercise;
    }

    @Override
    public Exercise getByCategoryId(Long categoryId) {
        Query query = session.openSession().getNamedQuery(Exercise.GET_BY_CATEGORY_ID)
                .setParameter("CATEGORY_ID", categoryId);
        Exercise exercise = (Exercise) query.uniqueResult();
        return exercise;
    }
}
