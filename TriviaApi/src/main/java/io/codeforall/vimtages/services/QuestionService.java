package io.codeforall.vimtages.services;

import io.codeforall.vimtages.model.Question;

import java.util.List;

public interface QuestionService {

    Question getQuestionById(Integer id);

    List<Question> getAllQuestions();
}
