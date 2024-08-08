package io.codeforall.drunkers.services;

import io.codeforall.drunkers.model.Answer;
import io.codeforall.drunkers.persistence.AnswerDao;
import io.codeforall.drunkers.persistence.dao.JpaAnswerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerDao answerDao;
    private JpaAnswerDao jpaAnswerDao;

    public AnswerDao getAnswerDao() {
        return answerDao;
    }

    @Autowired
    public void setAnswerDao(AnswerDao answerDao) {
        this.answerDao = answerDao;
    }

    public JpaAnswerDao getJpaAnswerDao() {
        return jpaAnswerDao;
    }

    @Autowired
    public void setJpaAnswerDao(JpaAnswerDao jpaAnswerDao) {
        this.jpaAnswerDao = jpaAnswerDao;
    }

    @Override
    public Answer get(Integer id) {
        return answerDao.findById(id);
    }

    @Override
    @Transactional
    public void delete(Answer answer) {
        answerDao.delete(answer);
    }

    public List<Answer> findByquestionId(Integer id) {
        return jpaAnswerDao.findByquestionId(id);
    }











}
