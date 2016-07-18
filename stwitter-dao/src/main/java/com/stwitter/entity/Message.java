package com.stwitter.entity;

import javax.persistence.*;

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
    private String timeSent;


    @ManyToOne
    @JoinColumn(name = "PERSON_FROM", insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "FK1_MESSAGE_PERSON")
    )
    private Person personFrom;

    @ManyToOne
    @JoinColumn(name = "PERSON_TO", insertable = false, updatable = false,
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
}
