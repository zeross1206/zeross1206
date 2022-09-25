package com.scar.test.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.scar.test.domain.Address} entity.
 */
public class AddressDTO implements Serializable {

    private Long id;

    private String country;

    private String city;

    private String district;

    private String commune;

    private String coordinate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AddressDTO)) {
            return false;
        }

        AddressDTO addressDTO = (AddressDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, addressDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AddressDTO{" +
            "id=" + getId() +
            ", country='" + getCountry() + "'" +
            ", city='" + getCity() + "'" +
            ", district='" + getDistrict() + "'" +
            ", commune='" + getCommune() + "'" +
            ", coordinate='" + getCoordinate() + "'" +
            "}";
    }
}
