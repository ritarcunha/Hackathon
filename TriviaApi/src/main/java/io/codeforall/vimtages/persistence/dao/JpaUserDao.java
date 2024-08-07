package io.codeforall.vimtages.persistence.dao;

import io.codeforall.vimtages.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class JpaUserDao extends GenericJpaDao<User> {

    public JpaUserDao(Class modelType) {
        super(modelType);
    }


}
