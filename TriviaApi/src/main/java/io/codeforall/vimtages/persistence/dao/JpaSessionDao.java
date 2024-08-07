package io.codeforall.vimtages.persistence.dao;

import io.codeforall.vimtages.model.Session;

public class JpaSessionDao extends GenericJpaDao<Session>{
    public JpaSessionDao(Class modelType) {
        super(modelType);
    }
}
