package io.codeforall.vimtages.controllers;

import io.codeforall.vimtages.model.Facts;
import io.codeforall.vimtages.services.FactService;
import io.codeforall.vimtages.services.FactServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/facts")
public class RestFactController {

    private FactService factService;
    @Autowired
    public void setFactService(FactService factService) {
        this.factService = factService;
    }
    @RequestMapping(method = RequestMethod.GET,path = {"/",""})
    public ResponseEntity<List<Facts>> listFacts(){
        List<Facts> factsList = factService.listAll();
        return new ResponseEntity<>(factsList, HttpStatus.OK);
    }
}
