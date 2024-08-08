package io.codeforall.drunkers.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="event")
public class Event implements Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer sessionId;

    private Integer userId;

    @CreationTimestamp
    private Date creationTime;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
