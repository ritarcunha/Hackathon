package io.codeforall.vimtages.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToOne(cascade = { CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "session")
    private Session session;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
