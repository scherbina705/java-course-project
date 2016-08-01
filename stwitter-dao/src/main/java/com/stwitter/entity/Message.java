package com.stwitter.entity;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Entity
@Table(name = "MESSAGE")
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "MESSAGE_ID")
    private Long id;

    private String content;

    @Column(name = "TIME_SENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeSent;

    @ManyToOne
    @JoinColumn(name = "PERSON_FROM",
            foreignKey = @ForeignKey(name = "FK1_MESSAGE_PERSON")
    )
    private Person personFrom;

    @ManyToOne
    @JoinColumn(name = "PERSON_TO",
            foreignKey = @ForeignKey(name = "FK2_MESSAGE_PERSON")
    )
    private Person personTo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return id.equals(message.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(Date timeSent) {
        this.timeSent = timeSent;
    }

    public Person getPersonFrom() {
        return personFrom;
    }

    public void setPersonFrom(Person personFrom) {
        this.personFrom = personFrom;
    }

    public Person getPersonTo() {
        return personTo;
    }

    public void setPersonTo(Person personTo) {
        this.personTo = personTo;
    }
}
