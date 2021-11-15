package com.project.theTrader.universe;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

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
  
    private int nodes;

    // @Transient
    // private Vector<Vector <Integer> > adj = new Vector<Vector<Integer>>(nodes); 
    

    public Universe() {
    }

    public Universe(int nodes) {
        this.nodes = nodes;
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


    @Override
    public String toString() {
        return "{" +
            // " universe='" + getUniverse() + "'" +
            ", nodes='" + getNodes() + "'" +
            "}";
    }

    public void addStar(Star star) {
        stars.add(star);
        star.setUniverse(this);
    }


    // public void printGraph(Vector<Vector <Integer> > adj, int nodes){
    //     for(int v = 0; v < nodes; v++){
    //         System.out.println("Lista de adyacencia del vertice: " + v + "\n head");
    //         for(Integer x: adj.get(v)){
    //             System.out.println("-> " + x);
    //         }
    //         System.out.println("\n");
    //     }


    // }
}
