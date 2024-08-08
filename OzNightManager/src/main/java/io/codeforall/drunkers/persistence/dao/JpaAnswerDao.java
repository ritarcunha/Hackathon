package io.codeforall.drunkers.persistence.dao;

import io.codeforall.drunkers.model.Answer;
import io.codeforall.drunkers.model.Group;
import io.codeforall.drunkers.model.Question;
import io.codeforall.drunkers.model.User;
import io.codeforall.drunkers.persistence.AnswerDao;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
@Repository
public class JpaAnswerDao extends GenericJpaDao <Answer> implements AnswerDao {

    public JpaAnswerDao() {
        super(Answer.class);
    }


    public List<Answer> findByquestionId(Integer id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Answer> criteriaQuery = cb.createQuery(Answer.class);
        Root<Answer> answer = criteriaQuery.from(Answer.class);
        criteriaQuery.select(answer).where(cb.equal(answer.get("question"), id));
        return em.createQuery(criteriaQuery).getResultList();
    }


}
