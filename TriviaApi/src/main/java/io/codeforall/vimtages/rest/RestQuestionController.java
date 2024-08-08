package io.codeforall.vimtages.rest;

import io.codeforall.vimtages.model.Question;
import io.codeforall.vimtages.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/question")
public class RestQuestionController {

    private QuestionService questionService;

    @Autowired
    public void setCustomerService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<Question>> listQuestions() {

        List<Question> questions = new ArrayList<>(questionService.getAllQuestions());

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}
