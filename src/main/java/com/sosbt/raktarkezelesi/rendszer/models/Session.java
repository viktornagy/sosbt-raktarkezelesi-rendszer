package com.sosbt.raktarkezelesi.rendszer.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Viktor on 2017.02.20..
 */
@Entity
@Table(name = "session")
@Data
public class Session {

    @Id
    String token;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user;
    @Temporal(value = TemporalType.TIMESTAMP)
    Date timestamp;
    @Temporal(value = TemporalType.TIMESTAMP)
    Date valid;

    @Transient
    final int DEFAULT_TIMEOUT = 30*60*1000;

    public Session() {
        long current_time=System.currentTimeMillis();
        this.timestamp=new Date(current_time);
        this.valid=new Date(current_time+DEFAULT_TIMEOUT);
    }


    public Session(int minutes) {
        this.timestamp = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.timestamp);
        cal.add(Calendar.MINUTE, minutes);
        this.valid = cal.getTime();
    }

    public Session(User user, int minutes) {
        this.timestamp = new Date();
        this.user = user;
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.timestamp);
        cal.add(Calendar.MINUTE, minutes);
        this.valid = cal.getTime();
    }

    public Session(String token, User user) {
        this.timestamp = new Date();
        this.user = user;
        this.token = token;
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.timestamp);
        cal.add(Calendar.MINUTE, DEFAULT_TIMEOUT);
        this.valid = cal.getTime();
    }

    public Session(String token, User user, int minutes) {
        this.timestamp = new Date();
        this.user = user;
        this.token = token;
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.timestamp);
        cal.add(Calendar.MINUTE, minutes);
        this.valid = cal.getTime();
    }
}
