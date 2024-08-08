package io.codeforall.drunkers.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "oz_group")
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

    @ManyToMany(
            // mappedBy required for bidirectional association
            mappedBy="ozGroups",

            // delay fetching users until they are actually needed
            fetch = FetchType.LAZY
    )
    private List<User> users = new ArrayList<>();

    @OneToOne()
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
