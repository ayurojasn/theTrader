package com.project.theTrader.universe;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.theTrader.star.Star;

@Entity
public class Universe {
   

    @Id
    @GeneratedValue
    private long id;
    
    @OneToMany(mappedBy = "universe")
    @JsonManagedReference(value = "star")
    @JsonIgnoreProperties(value = {"x", "y", "z", "inhabited", "planetList", "spaceStarList", "universe"})
    private List<Star> stars = new ArrayList<>(); 
    // Dentro de Star, lista de Planetas "ArrayList<Star> -> Star -> ArrayList<Planeta>"
    // @JsonIgnore
   // private ArrayList<ArrayList<Star>> adjancyList;
    // La infromación del grafo conectado

    private int nodes;
    private int edges;


    public Universe() {
    }

    public Universe(int nodes, int edges) {
        this.nodes = nodes;
        this.edges = edges;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }


    // public List<Star> getUniverse() {
    //     return this.stars;
    // }

    // public void setUniverse(ArrayList<Star> stars) {
    //     this.stars = stars;
    // }

    public int getNodes() {
        return this.nodes;
    }

    public void setNodes(int nodes) {
        this.nodes = nodes;
    }

    public int getEdges() {
        return this.edges;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "{" +
            // " universe='" + getUniverse() + "'" +
            ", nodes='" + getNodes() + "'" +
            ", edges='" + getEdges() + "'" +
            "}";
    }

    public void addStar(Star star) {
        stars.add(star);
        star.setUniverse(this);
    }
}
