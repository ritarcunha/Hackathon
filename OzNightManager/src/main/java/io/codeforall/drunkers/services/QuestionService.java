package io.codeforall.drunkers.services;

import io.codeforall.drunkers.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;


public interface QuestionService {

    Question getQuestionById(Integer id);

    List<Question> getAllQuestions();
}
