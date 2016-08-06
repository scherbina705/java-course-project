package com.stwitter.entity;

import javax.persistence.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by A.Shcherbina
 * on 10.07.2016.
 */
@Entity
@Table(name = "Place")
public class Place {
    @Id
    @GeneratedValue
    @Column(name = "PLACE_ID")
    private Long id;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String description;

    private Float latitude;

    private Float longtitude;

    @OneToOne
    @JoinColumn(name = "PERSON_ID",
            foreignKey = @ForeignKey(name = "FK_PLACE_PERSON")
    )
    private Person person;

    public Place() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Float longtitude) {
        this.longtitude = longtitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Place place = (Place) o;

        return new EqualsBuilder()
                .append(getPerson(), place.getPerson())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPerson())
                .toHashCode();
    }
}
