package com.scar.test.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.scar.test.domain.Image} entity.
 */
public class ImageDTO implements Serializable {

    private Long id;

    private String image;

    private UserDTO user_image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public UserDTO getUser_image() {
        return user_image;
    }

    public void setUser_image(UserDTO user_image) {
        this.user_image = user_image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ImageDTO)) {
            return false;
        }

        ImageDTO imageDTO = (ImageDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, imageDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ImageDTO{" +
            "id=" + getId() +
            ", image='" + getImage() + "'" +
            ", user_image=" + getUser_image() +
            "}";
    }
}
