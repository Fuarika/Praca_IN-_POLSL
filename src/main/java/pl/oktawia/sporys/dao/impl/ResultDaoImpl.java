package pl.oktawia.sporys.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import pl.oktawia.sporys.dao.ResultDao;
import pl.oktawia.sporys.model.Result;

@Component
public class ResultDaoImpl extends GenericDaoImpl<Result> implements ResultDao {

    //@Override
    //public Result getByExerciseId(Long exerciseId) {
    //    Query query = session.openSession().getNamedQuery(Result.GET_BY_EXERCISE_ID)
    //            .setParameter("EXERCISE_ID", exerciseId);
    //    Result result = (Result) query.uniqueResult();
    //    return result;
   // }
}
