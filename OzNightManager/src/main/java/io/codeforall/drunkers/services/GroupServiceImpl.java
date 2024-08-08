package io.codeforall.drunkers.services;

import io.codeforall.drunkers.model.Group;
import io.codeforall.drunkers.model.User;
import io.codeforall.drunkers.persistence.GroupDao;
import io.codeforall.drunkers.persistence.UserDao;
import io.codeforall.drunkers.persistence.dao.JpaGroupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService{

    private UserDao userDao;

    private GroupDao groupDao;

    private JpaGroupDao jpaGroupDao;

    @Autowired
    public void setGroupDao(JpaGroupDao groupDao) {
        this.jpaGroupDao = groupDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public GroupDao getGroupDao() {
        return groupDao;
    }

    @Override
    public Group get(Integer id) {
        return groupDao.findById(id);
    }

    @Override
    @Transactional
    public void delete(Group group) {
        jpaGroupDao.delete(group);
    }

    @Override
    public List<Group> list() {
        return groupDao.findAll();
    }

    @Override
    @Transactional
    public Group addUser(Group group) {
        return groupDao.saveOrUpdate(group);
    }

    @Override
    public List<User> listUser(Integer id) {
        return jpaGroupDao.listGroupsByUserId(id);
    }

    @Override
    @Transactional
    public void removeUser(Group group) {
        groupDao.saveOrUpdate(group);
    }
}
