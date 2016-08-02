package com.stwitter.dto;

import com.stwitter.entity.Hobby;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * (c) Swissquote 8/2/16
 *
 * @author Shcherbina A.
 */
public class HobbyDto {
    private Long id;
    private String title;
    private String description;

    public static Hobby convertToEntity(HobbyDto dto) {
        Hobby h = new Hobby();
        h.setDescription(dto.getDescription());
        h.setTitle(dto.getTitle());
        h.setId(dto.getId());
        return h;
    }

    public static HobbyDto convertToDto(Hobby entity) {
        HobbyDto h = new HobbyDto();
        h.setDescription(entity.getDescription());
        h.setTitle(entity.getTitle());
        h.setId(entity.getId());
        return h;
    }

    public static void main(String[] args) {
        Hobby entity = new Hobby();
        convertToDto(entity);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HobbyDto hobbyDto = (HobbyDto) o;

        return new EqualsBuilder()
                .append(id, hobbyDto.id)
                .append(title, hobbyDto.title)
                .append(description, hobbyDto.description)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(title)
                .append(description)
                .toHashCode();
    }
}
