package io.codeforall.drunkers.services;

import io.codeforall.drunkers.model.User;
import io.codeforall.drunkers.persistence.dao.JpaLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

    private JpaLoginDao loginDao;

    @Autowired
    public void setLoginDao(JpaLoginDao loginDao) {
        this.loginDao = loginDao;
    }

    // If this method returns a User with only the username filled, that means that User found, but password
    // doesn't match
    // However if returns null, there's nothing that match the username and password
    // And finally if returns another thing it's the all user founded.
    @Override
    public User getUserByUsernameAndPassword(String username, String password) {

        User userForName;
        User userForReturn = new User();
        User userReturn = null;

        if((userReturn = loginDao.getUserByNameAndPassword(username, password)) != null) {
            return userReturn;
        }

        if((userForName = loginDao.getUserByName(username)) != null) {
            userForReturn.setUsername(userForName.getUsername());
        }

        return userForReturn;

    }
}
