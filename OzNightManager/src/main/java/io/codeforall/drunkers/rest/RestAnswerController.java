package io.codeforall.drunkers.rest;

import io.codeforall.drunkers.model.Answer;
import io.codeforall.drunkers.model.Question;
import io.codeforall.drunkers.persistence.dao.JpaAnswerDao;
import io.codeforall.drunkers.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/answer")
public class RestAnswerController {

    AnswerService answerService;

    JpaAnswerDao jpaAnswerDao;


    public AnswerService getAnswerService() {
        return answerService;
    }

    @Autowired
    public void setAnswerService(AnswerService answerService) {
        this.answerService = answerService;
    }

    public JpaAnswerDao getJpaAnswerDao() {
        return jpaAnswerDao;
    }

    @Autowired
    public void setJpaAnswerDao(JpaAnswerDao jpaAnswerDao) {
        this.jpaAnswerDao = jpaAnswerDao;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Answer> showAnswer(@PathVariable Integer id) {

        Answer answer = answerService.get(id);

        if (answer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")

    public ResponseEntity<Answer> deleteAnswer(@PathVariable Integer id) {

        Answer answer = answerService.get(id);
        answerService.delete(answer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping(method = RequestMethod.GET, path = {"/question/{id}"})
    public ResponseEntity<List<Answer>> listAnswers(@PathVariable Integer id) {

        List<Answer> answers = jpaAnswerDao.findByquestionId(id);


        return new ResponseEntity<>(answers, HttpStatus.OK);
        /*
        Answer answer = new Answer();
        answer.setMessage("Olaaa");

        List<Answer> answers = new ArrayList<>();

        answers.add(answer);

        return new ResponseEntity<>(answers, HttpStatus.OK);

         */
    }


}










