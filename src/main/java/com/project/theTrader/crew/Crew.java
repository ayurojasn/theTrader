package com.project.theTrader.crew;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.theTrader.player.Player;
import com.project.theTrader.product.Product;
import com.project.theTrader.productCrew.ProductCrew;
import com.project.theTrader.spacecraft.Spacecraft;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","referenceList"})
public class Crew {
    
    @Id 
    @GeneratedValue
    private Long id;
    private String crewName;
    private double credits;
    private Integer totalTime; // Minutes

    @OneToOne
    @JoinColumn(name = "spacescraft", referencedColumnName = "id")
    @JsonIgnoreProperties(value = { "craftName", "cargo", "totalTime", "speed", "playerList", "productCrewList"})
    private Spacecraft spacecraft = new Spacecraft();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crew")
    private List<Player> playerList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "crew")
    @JsonIgnore
    @JsonManagedReference(value = "productCrew")
    private List<ProductCrew> productCrewList = new ArrayList<>();

    @JsonIgnore
    public List<ProductCrew> getProductCrewList(){
        return this.productCrewList;
    }

    
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

    public Spacecraft getSpacecraft() {
        return this.spacecraft;
    }

    public void setSpacecraft(Spacecraft spacecraft) {
        this.spacecraft = spacecraft;
        this.spacecraft.setCrew(this); // Add crew to spacecraft
    }

    public List<Player> getPlayerList() {
        return this.playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
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

    // Add Player in Crew -> List of players in Crew
    public void addPlayer(Player player) {
            playerList.add(player);
            player.setCrew(this);
    
    }

    public void addProduct(Product product) {
        ProductCrew productC = new ProductCrew(product, this);
        productCrewList.add(productC);
    }

    



}
