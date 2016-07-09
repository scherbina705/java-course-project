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
@Table(name = "HOBBY")
public class Hobby {
    @Id
    @GeneratedValue
    @Column(name = "HOBBY_ID")
    private Long id;

    private String title;

    private String description;

    public Hobby() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
