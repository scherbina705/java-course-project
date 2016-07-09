package entities;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;


/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@DynamicUpdate
@Table(name = "FRIENDSHIP")
public class Friendship {
    //Id
    //TODO: Find out how to map 2 id's
    @Column(name = "PERSON_ID")
    private Long personId;

    //TODO: Find out how to map 2 id's
    //also Id (probably should be composite key)
    @Column(name = "FRIEND_ID")
    private Long friendId;

    @Column(name = "DATE_FROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFrom;

    public Friendship() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }
}
