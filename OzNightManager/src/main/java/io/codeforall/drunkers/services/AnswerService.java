package io.codeforall.drunkers.services;

import io.codeforall.drunkers.model.Answer;
import io.codeforall.drunkers.model.Group;
import io.codeforall.drunkers.model.Question;
import io.codeforall.drunkers.model.User;

import java.util.List;

public interface AnswerService {

    Answer get (Integer id);

    void delete(Answer answer);





}
