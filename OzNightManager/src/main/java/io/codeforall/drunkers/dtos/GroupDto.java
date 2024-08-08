package io.codeforall.drunkers.dtos;

import io.codeforall.drunkers.model.Session;
import io.codeforall.drunkers.model.User;
import java.util.List;

public class GroupDto {

    private Integer id;

    private String name;

    private Session session;

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
