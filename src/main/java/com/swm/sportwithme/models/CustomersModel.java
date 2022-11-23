package com.swm.sportwithme.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
@Data
@Entity
@Table(name = "customers")
public class CustomersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String login;
    private String phoneNumber;
    private Integer age;
    private String photoLink;
    private Integer eventsOrganized;
    private Integer strikes;

    public CustomersModel(String login, String phoneNumber) {
        if (!login.equals(""))
            this.login = login;
        if (!phoneNumber.equals(""))
            this.phoneNumber = phoneNumber;
        this.eventsOrganized = 0;
        this.strikes = 0;
    }

    public CustomersModel() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomersModel that = (CustomersModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(login, that.login) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(age, that.age) && Objects.equals(photoLink, that.photoLink) && Objects.equals(eventsOrganized, that.eventsOrganized) && Objects.equals(strikes, that.strikes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, phoneNumber, age, photoLink, eventsOrganized, strikes);
    }

    @Override
    public String toString() {
        return "CustomersModel{" +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                ", photoLink='" + photoLink + '\'' +
                ", eventsOrganized=" + eventsOrganized +
                ", strikes=" + strikes +
                '}';
    }
}
