package io.codeforall.vimtages.services;

import io.codeforall.vimtages.model.Question;
import io.codeforall.vimtages.persistence.dao.JpaLoginDao;
import io.codeforall.vimtages.persistence.dao.JpaQuestionDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QuestionServiceImpl implements QuestionService{

    private JpaQuestionDao questionDao;

    @Autowired
    public void setLoginDao(JpaQuestionDao questionDao) {
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
