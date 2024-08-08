package io.codeforall.drunkers.persistence.dao;

import io.codeforall.drunkers.model.Question;
import io.codeforall.drunkers.persistence.QuestionDao;
import org.springframework.stereotype.Repository;

@Repository
public class JpaQuestionDao  extends GenericJpaDao<Question> implements QuestionDao {

    public JpaQuestionDao() {
        super(Question.class);
    }

}
