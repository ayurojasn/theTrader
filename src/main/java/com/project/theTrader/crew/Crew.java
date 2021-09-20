package com.project.theTrader.crew;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Crew {
    
    @Id 
    @GeneratedValue
    private Long id;
    private String crewName;
    private double credits;
    private Integer totalTime;
    
    public Crew() {
    }

    public Crew(String crewName, double credits, Integer totalTime) {
        this.crewName = crewName;
        this.credits = credits;
        this.totalTime = totalTime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrewName() {
        return this.crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public double getCredits() {
        return this.credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public Integer getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(Integer totalTime) {
        this.totalTime = totalTime;
    }
 

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", crewName='" + getCrewName() + "'" +
            ", credits='" + getCredits() + "'" +
            ", totalTime='" + getTotalTime() + "'" +
            "}";
    }

    



}
