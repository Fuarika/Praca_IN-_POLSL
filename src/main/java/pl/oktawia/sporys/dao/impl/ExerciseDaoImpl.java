package pl.oktawia.sporys.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import pl.oktawia.sporys.dao.ExerciseDao;
import pl.oktawia.sporys.model.Exercise;
import pl.oktawia.sporys.model.Result;

@Component
public class ExerciseDaoImpl extends GenericDaoImpl<Exercise> implements ExerciseDao {

    @Override
    public Exercise getById(Integer id) {
        Query query = session.openSession().getNamedQuery(Exercise.GET_BY_ID)
                .setParameter("ID", id);
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

    @Override
    public Exercise getByResultId(Integer resultId) {
        Query query = session.openSession().getNamedQuery(Exercise.GET_BY_RESULT_ID)
                .setParameter("RESULT_FK", resultId);
        Exercise exercise = (Exercise) query.uniqueResult();
        return exercise;
    }
}
