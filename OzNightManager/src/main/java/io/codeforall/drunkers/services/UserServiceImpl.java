package io.codeforall.drunkers.services;

import io.codeforall.drunkers.model.Group;
import io.codeforall.drunkers.model.User;
import io.codeforall.drunkers.persistence.GroupDao;
import io.codeforall.drunkers.persistence.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{

   private UserDao userDao;
   private GroupDao groupDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Autowired
    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public User get(Integer id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> list() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public User addGroup(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Override
    public List<Group> listGroups(Integer id) {
        return groupDao.findAll();
    }

    @Override
    @Transactional
    public void removeGroup(User user) {
        userDao.saveOrUpdate(user);
    }

}
