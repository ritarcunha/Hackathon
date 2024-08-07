package io.codeforall.vimtages.model;

import javax.persistence.*;
import java.beans.EventSetDescriptor;
import java.security.acl.Group;
import java.util.List;

@Entity
@Table(name ="session")
public class Session implements Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean sessionState;
    private List <Event> events;

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isSessionState() {
        return sessionState;
    }

    public void setSessionState(boolean sessionState) {
        this.sessionState = sessionState;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @OneToOne(cascade = { CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "owner")
    private Group group;


}
