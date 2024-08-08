package io.codeforall.drunkers.converters;

import io.codeforall.drunkers.dtos.SessionDto;
import io.codeforall.drunkers.model.Session;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SessionToSessionDto implements Converter<Session, SessionDto> {

    @Override
    public SessionDto convert(Session session) {

        SessionDto sessionDto = new SessionDto();
        sessionDto.setSessionState(session.isSessionState());
        sessionDto.setId(session.getId());
        sessionDto.setGroup(sessionDto.getGroup());

    return sessionDto;
    }
}
