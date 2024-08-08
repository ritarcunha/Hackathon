package io.codeforall.drunkers.model;

import javax.persistence.*;

@Entity
@Table(name ="session")
public class Session implements Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean sessionState;

    private String name;

    @OneToOne(cascade = { CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "session")
    private Group group;

    public boolean isSessionState() {
        return sessionState;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSessionState(boolean sessionState) {
        this.sessionState = sessionState;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
