package io.codeforall.drunkers.rest;

import io.codeforall.drunkers.model.Question;
import io.codeforall.drunkers.model.Session;
import io.codeforall.drunkers.services.QuestionService;
import io.codeforall.drunkers.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/session")
public class RestSessionController {
    private SessionService sessionService;

    @Autowired
    public void setSessionServiceService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{cid}"})
    public ResponseEntity<Session> getSessionQuestions(@RequestBody Integer id) {
       Session session =  sessionService.get(id);


        return new ResponseEntity<>(session, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Session> deleteCustomer(@PathVariable Integer id) {

           Session session= sessionService.get(id);
                    sessionService.delete(session);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    }




}
