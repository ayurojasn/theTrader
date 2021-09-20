package com.project.theTrader.spacecraft;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.project.theTrader.crew.Crew;
import com.project.theTrader.star.Star;

@Entity
public class Spacecraft {

    @Id
    @GeneratedValue
    private Long id;
    private String craftName;
    private double cargo;
    private double speed;

    @OneToOne(mappedBy = "spacecraft")
    @JsonBackReference
    private Crew crew;
    

    @ManyToOne
    @JsonBackReference(value = "spacecraft")
    private Star star;

    public Spacecraft() {
    }

    public Spacecraft(String craftName, double cargo, double speed) {
        this.craftName = craftName;
        this.cargo = cargo;
        this.speed = speed;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCraftName() {
        return this.craftName;
    }

    public void setCraftName(String craftName) {
        this.craftName = craftName;
    }

    public double getCargo() {
        return this.cargo;
    }

    public void setCargo(double cargo) {
        this.cargo = cargo;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Crew getCrew() {
        return this.crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    
    public Star getStar() {
        return this.star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", craftName='" + getCraftName() + "'" +
            ", cargo='" + getCargo() + "'" +
            ", speed='" + getSpeed() + "'" +
            "}";
    }
    
    
}
