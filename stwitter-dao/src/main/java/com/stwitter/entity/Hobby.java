package com.stwitter.entity;

import javax.persistence.*;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Entity
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

    public Hobby(String title, String description) {
        this.title = title;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hobby hobby = (Hobby) o;

        return id.equals(hobby.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
