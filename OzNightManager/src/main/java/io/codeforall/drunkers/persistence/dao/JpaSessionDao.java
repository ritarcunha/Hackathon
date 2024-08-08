package io.codeforall.drunkers.persistence.dao;

import io.codeforall.drunkers.model.Session;
import io.codeforall.drunkers.persistence.SessionDao;
import org.springframework.stereotype.Repository;

@Repository
public class JpaSessionDao extends GenericJpaDao<Session> implements SessionDao {
    public JpaSessionDao() {
        super(Session.class);
    }
}
