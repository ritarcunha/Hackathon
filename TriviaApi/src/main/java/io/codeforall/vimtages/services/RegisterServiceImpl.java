package io.codeforall.vimtages.services;

import io.codeforall.vimtages.model.User;
import io.codeforall.vimtages.persistence.RegisterDao;
import io.codeforall.vimtages.persistence.dao.JpaLoginDao;
import io.codeforall.vimtages.persistence.dao.JpaRegisterDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

public class RegisterServiceImpl implements RegisterService {

    private JpaRegisterDao jpaRegisterDao;

    @Autowired
    public void setLoginDao(JpaRegisterDao jpaRegisterDao) {
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
