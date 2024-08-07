package io.codeforall.vimtages.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(
            // propagate changes on group entity to user entity
            cascade = {CascadeType.ALL},

            // make sure to remove users if unlinked from group
            orphanRemoval = true,

            // use user foreign key on user table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "answer"
    )
    private List<Answer> answers;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
