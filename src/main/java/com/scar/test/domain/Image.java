package com.scar.test.domain;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;

/**
 * A Image.
 */
@Entity
@Table(name = "image")
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "image")
    private String image;

    @Column(name = "uploaded_date", nullable = false)
    private Instant uploadedDate;

    public Long getId() {
        return this.id;
    }

    public Image id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return this.image;
    }

    public Image image(String image) {
        this.setImage(image);
        return this;
    }

    public Instant getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(Instant uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Image)) {
            return false;
        }
        return id != null && id.equals(((Image) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Image{" +
            "id=" + getId() +
            ", image='" + getImage() + "'" +
            "}";
    }
}
