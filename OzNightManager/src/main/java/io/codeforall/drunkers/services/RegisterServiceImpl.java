package io.codeforall.drunkers.services;

import io.codeforall.drunkers.model.User;
import io.codeforall.drunkers.persistence.dao.JpaRegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class RegisterServiceImpl implements RegisterService {

    private JpaRegisterDao jpaRegisterDao;

    @Autowired
    public void setRegisterDao(JpaRegisterDao jpaRegisterDao) {
        this.jpaRegisterDao = jpaRegisterDao;
    }

    @Transactional
    @Override
    public User save(User user) {
        if(jpaRegisterDao.checkUserExists(user)) {
            return null;
        }

        return jpaRegisterDao.saveOrUpdate(user);
    }
}
