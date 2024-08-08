package io.codeforall.drunkers.model;

import javax.persistence.*;

    @Entity
    @Table(name = "answer")
    public class Answer implements Model {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String message;

        @ManyToOne (cascade = { CascadeType.PERSIST})
        private Question question;

        public Integer getId() {
            return id;
        }

        @Override
        public String getName() {
            return null;
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
