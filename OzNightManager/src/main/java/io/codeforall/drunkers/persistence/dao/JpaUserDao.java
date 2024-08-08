package io.codeforall.drunkers.persistence.dao;

import io.codeforall.drunkers.model.User;

import org.springframework.stereotype.Repository;

@Repository
public class JpaUserDao extends GenericJpaDao<User> {

    public JpaUserDao() {
        super(User.class);
    }


}
