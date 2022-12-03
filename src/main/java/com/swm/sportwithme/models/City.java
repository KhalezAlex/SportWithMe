package com.swm.sportwithme.models;

import javax.persistence.*;
//
//@Entity
//@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;

    // ссылка на страну -многие к одному - сделать

    public City(String name) {
        this.name = name;
    }

    public City() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
