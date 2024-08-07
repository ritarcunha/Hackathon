package io.codeforall.vimtages.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="user")
public class User implements Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String username;

    private String password;

    @CreationTimestamp
    private Date creationTime;

    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},

            // make sure to remove accounts if unlinked from customer
            orphanRemoval = true,

            // user customer foreign key on account table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "group",

            // fetch accounts from database together with user
            fetch = FetchType.EAGER
    )
    private List<Group> groups = new ArrayList<>();

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}

