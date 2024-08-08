package io.codeforall.drunkers.services;

import io.codeforall.drunkers.model.Group;
import io.codeforall.drunkers.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GroupService {

    Group get (Integer id);

    void delete(Group group);

    List<Group> list();

    Group addUser(Group group);

    List<User> listUser(Integer id);

    void removeUser(Group group);

}
