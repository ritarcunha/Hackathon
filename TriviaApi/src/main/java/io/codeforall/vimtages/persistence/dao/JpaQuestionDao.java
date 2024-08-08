package io.codeforall.vimtages.persistence.dao;

import io.codeforall.vimtages.model.Question;
import io.codeforall.vimtages.model.User;
import io.codeforall.vimtages.persistence.QuestionDao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class JpaQuestionDao  extends GenericJpaDao<Question> implements QuestionDao {

    private EntityManager entityManager;

    public JpaQuestionDao(Class<Question> modelType) {
        super(modelType);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



}
