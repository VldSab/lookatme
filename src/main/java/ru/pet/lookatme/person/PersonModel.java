package ru.pet.lookatme.person;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
@Table
public class PersonModel {
    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    Long id;
    String ip;
    Double latitude;
    Double longitude;
    String city;
    @JsonProperty("country_name")
    String countryName;

    public PersonModel(String ip, Double latitude, Double longitude, String city, String countryName) {
        this.ip = ip;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.countryName = countryName;
    }

    public PersonModel(Long id, String ip, Double latitude, Double longitude, String city, String countryName) {
        this.id = id;
        this.ip = ip;
        this.latitude = latitude;
        this.longitude = longitude;
        this.city = city;
        this.countryName = countryName;
    }

    public PersonModel() {
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", city='" + city + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
