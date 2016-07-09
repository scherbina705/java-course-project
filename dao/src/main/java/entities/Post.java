package entities;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@DynamicUpdate
@Table(name = "POST")
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "POST_ID")
    private Long id;

    private String title;

    private String content;

    @Column(name = "PLACE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date placeTime;

    //Foreign key
    //TODO: map
    private Long person_id;

}
