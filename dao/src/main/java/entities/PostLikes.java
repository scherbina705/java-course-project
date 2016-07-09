package entities;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@DynamicUpdate
@Table(name = "POST_LIKES")
public class PostLikes {
    //TODO: Find out how to map 2 id's
    @Column(name = "POST_ID")
    private Long postId;

    //TODO: Find out how to map 2 id's
    //also Id (probably should be composite key)
    @Column(name = "PERSON_ID")
    private Long personId;
}
