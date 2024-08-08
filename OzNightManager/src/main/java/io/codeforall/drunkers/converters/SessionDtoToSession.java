package io.codeforall.drunkers.converters;

import io.codeforall.drunkers.dtos.SessionDto;
import io.codeforall.drunkers.model.Session;
import io.codeforall.drunkers.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SessionDtoToSession implements Converter<SessionDto, Session> {

    SessionService sessionService;

    @Autowired
    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public Session convert(SessionDto sessionDto) {

        Session session=(sessionDto.getId() !=null ? sessionService.get(sessionDto.getId()) :new Session());

        session.setGroup(sessionDto.getGroup());
        session.setId(session.getId());
        session.setName(session.getName());
        session.setSessionState(sessionDto.isSessionState());

        return session;
    }
}
