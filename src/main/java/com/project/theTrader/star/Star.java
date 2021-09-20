package com.project.theTrader.star;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.theTrader.planet.Planet;

@Entity
public class Star {

    @Id
    @GeneratedValue
    private Long id;
    private String starName;
    private Integer x;
    private Integer y;
    private Integer z;
    private boolean inhabited;

    @OneToMany(mappedBy = "star")
    @JsonManagedReference(value = "star-planet")
    private List<Planet> planetList = new ArrayList<>();

    public Star() {
    }

    public Star(String starName, Integer x, Integer y, Integer z, boolean inhabited) {
        this.starName = starName;
        this.x = x;
        this.y = y;
        this.z = z;
        this.inhabited = inhabited;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStarName() {
        return this.starName;
    }

    public void setStarName(String starName) {
        this.starName = starName;
    }

    public Integer getX() {
        return this.x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return this.y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getZ() {
        return this.z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public boolean isInhabited() {
        return this.inhabited;
    }

    public boolean getInhabited() {
        return this.inhabited;
    }

    public void setInhabited(boolean inhabited) {
        this.inhabited = inhabited;
    }


    // public List<Planet> getPlanetList() {
    //     return this.planetList;
    // }

    // public void setPlanetList(List<Planet> planetList) {
    //     this.planetList = planetList;
    // }


    // @Override
    // public String toString() {
    //     return "{" +
    //         " id='" + getId() + "'" +
    //         ", starName='" + getStarName() + "'" +
    //         ", x='" + getX() + "'" +
    //         ", y='" + getY() + "'" +
    //         ", z='" + getZ() + "'" +
    //         ", inhabited='" + isInhabited() + "'" +
    //         "}";
    // }

    // // Add Planet in planetList in Star -> Planets in Star
    public boolean addPlanet(Planet planet) {
        if(!planetList.contains(planet)){
            planetList.add(planet);
            planet.setStar(this);
            return true;
        }
            return false;
    }

    
}
