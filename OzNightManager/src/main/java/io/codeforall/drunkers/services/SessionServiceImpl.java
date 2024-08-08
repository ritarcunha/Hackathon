package io.codeforall.drunkers.services;

import io.codeforall.drunkers.model.Session;
import io.codeforall.drunkers.persistence.SessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class SessionServiceImpl implements SessionService{

    private SessionDao sessionDao;

    public SessionDao getSessionDao() {
        return sessionDao;
    }

    @Autowired
    public void setSessionDao(SessionDao sessionDao) {
        this.sessionDao = sessionDao;
    }

    @Override
    public Session get(Integer id) {
        return sessionDao.findById(id);
    }

    @Override
    @Transactional
    public void delete(Session session) {
        sessionDao.delete(session);
    }

    @Override
    public List<Session> list() {
        return sessionDao.findAll();
    }
}
