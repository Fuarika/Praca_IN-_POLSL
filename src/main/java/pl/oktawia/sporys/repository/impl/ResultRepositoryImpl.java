package pl.oktawia.sporys.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.oktawia.sporys.model.Result;
import org.hibernate.SessionFactory;

public class ResultRepositoryImpl {

    @Autowired
    SessionFactory session;

    Integer insertResult(String answer, String step1, String step2, String step3, String step4 ){
        Result result = new Result();
        result.setAnswer(answer);
        result.setStep_1(step1);
        result.setStep_2(step2);
        result.setStep_3(step3);
        result.setStep_4(step4);
        //session.persist(result);

        //Integer resultId = (Integer)session.save(result);
        return 1; // wzraca id do resulta
    }
}
