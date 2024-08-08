package io.codeforall.drunkers.services;

import io.codeforall.drunkers.model.Question;
import io.codeforall.drunkers.persistence.dao.JpaQuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService{

    private JpaQuestionDao questionDao;

    @Autowired
    public void setQuestionDao(JpaQuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public Question getQuestionById(Integer id) {
        return questionDao.findById(id);
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }
}
