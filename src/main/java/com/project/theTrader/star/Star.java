package com.project.theTrader.star;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.theTrader.planet.Planet;
import com.project.theTrader.spacecraft.Spacecraft;
import com.project.theTrader.universe.Universe;

import org.hibernate.annotations.ManyToAny;

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
    private int posGrafo;


    @OneToMany(mappedBy = "star")
    @JsonManagedReference(value = "planetStar")
    private List<Planet> planetList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "star")
    @JsonManagedReference(value = "spacecraft")
    private List<Spacecraft> spaceStarList = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    private Universe universe;


    
    public Universe getUniverse() {
        return this.universe;
    }

    public void setUniverse(Universe universe) {
        this.universe = universe;
    }

    public Star() {
    }

    public Star(String starName, Integer x, Integer y, Integer z, boolean inhabited, int posGrafo) {
        this.starName = starName;
        this.x = x;
        this.y = y;
        this.z = z;
        this.inhabited = inhabited;
        this.posGrafo = posGrafo;
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

    public int getPosGrafo() {
        return this.posGrafo;
    }

    public void setPosGrafo(int posGrafo) {
        this.posGrafo = posGrafo;
    }

    public List<Planet> getPlanetList() {
        return this.planetList;
    }

    public void setPlanetList(List<Planet> planetList) {
        this.planetList = planetList;
    }

    public List<Spacecraft> getSpaceStarList() {
        return this.spaceStarList;
    }

    public void setSpaceStarList(List<Spacecraft> spaceStarList) {
        this.spaceStarList = spaceStarList;
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

    public void addSpacecraft(Spacecraft craft) {
        if (!spaceStarList.contains(craft)) {
            spaceStarList.add(craft);
            craft.setStar(this);
        }
    }

    
}
