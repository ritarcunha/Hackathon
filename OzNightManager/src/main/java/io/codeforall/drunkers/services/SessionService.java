package io.codeforall.drunkers.services;

import io.codeforall.drunkers.model.Session;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SessionService {

    Session get (Integer id);

    void delete(Session session);

    List<Session> list();

}
