package io.codeforall.vimtages.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;





import javax.persistence.*;

    @Entity
    @Table(name = "answer")
    public class Answer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String message;

        @ManyToOne
        private Question question;

        public Integer getId() {
            return id;
        }

        public String getMessage() {
            return message;
        }

        public Question getQuestion() {
            return question;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setQuestion(Question question) {
            this.question = question;
        }
    }
