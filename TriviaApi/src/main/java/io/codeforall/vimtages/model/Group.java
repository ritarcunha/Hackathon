package io.codeforall.vimtages.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "group")
public class Group implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @OneToMany(
            // propagate changes on group entity to user entity
            cascade = {CascadeType.ALL},

            // make sure to remove users if unlinked from group
            orphanRemoval = true,

            // use user foreign key on user table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "user"
    )
    private List<User> users = new ArrayList<>();
}
