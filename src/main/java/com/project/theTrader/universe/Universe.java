package com.project.theTrader.universe;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.project.theTrader.star.Star;

@Entity
public class Universe {
   
    @Id
    @GeneratedValue
    private long id;
    private ArrayList<Star> universe = new ArrayList<>(); 
    // Dentro de Star, lista de Planetas "ArrayList<Star> -> Star -> ArrayList<Planeta>"
    private ArrayList<ArrayList<Star>> adjancyList;
    // La infromación del grafo conectado

    private int nodes;
    private int edges;


    public Universe() {
    }

    public Universe(ArrayList<Star> universe, ArrayList<ArrayList<Star>> adjancyList, int nodes, int edges) {
        this.universe = universe;
        this.adjancyList = adjancyList;
        this.nodes = nodes;
        this.edges = edges;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public ArrayList<Star> getUniverse() {
        return this.universe;
    }

    public void setUniverse(ArrayList<Star> universe) {
        this.universe = universe;
    }

    public ArrayList<ArrayList<Star>> getAdjancyList() {
        return this.adjancyList;
    }

    public void setAdjancyList(ArrayList<ArrayList<Star>> adjancyList) {
        this.adjancyList = adjancyList;
    }

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
            " universe='" + getUniverse() + "'" +
            ", adjancyList='" + getAdjancyList() + "'" +
            ", nodes='" + getNodes() + "'" +
            ", edges='" + getEdges() + "'" +
            "}";
    }



}
