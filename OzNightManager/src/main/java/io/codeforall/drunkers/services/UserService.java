package io.codeforall.drunkers.services;

import io.codeforall.drunkers.model.Group;
import io.codeforall.drunkers.model.User;

import java.util.List;

public interface UserService {
    User get (Integer id);

    void delete(User user);

    List<User> list();

    User addGroup(User user);

    List<Group> listGroups(Integer id);

    void removeGroup(User user);

}
