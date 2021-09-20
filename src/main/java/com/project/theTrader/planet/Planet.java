package com.project.theTrader.planet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Planet {

    @Id
    @GeneratedValue
    private Long id;
    private String planetName;


    public Planet() {
    }

    public Planet(String planetName) {
        this.planetName = planetName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanetName() {
        return this.planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", planetName='" + getPlanetName() + "'" +
            "}";
    }

    
}
