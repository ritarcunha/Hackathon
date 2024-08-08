package io.codeforall.drunkers.dtos;

import io.codeforall.drunkers.model.Group;

public class SessionDto {

    private Integer id;

    private boolean sessionState;

    private String name;

    private Group group;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isSessionState() {
        return sessionState;
    }

    public void setSessionState(boolean sessionState) {
        this.sessionState = sessionState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
