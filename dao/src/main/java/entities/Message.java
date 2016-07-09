package entities;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@DynamicUpdate
@Table(name = "MESSAGE")
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "MESSAGE_ID")
    private Long id;

    private String content;

    @Column(name = "TIME_SENT")
    private String timeSent;

    @Column(name = "PERSON_FROM")
    //TODO: map
    // Foreign key 1
    private Long personFrom;

    @Column(name = "PERSON_TO")
    //TODO: Find map
    // Foreign key 2
    private Long personTo;
}
