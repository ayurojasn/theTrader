package com.project.theTrader.universe;

import java.util.ArrayList;

import javax.persistence.Entity;

import com.project.theTrader.star.Star;

@Entity
public class Universe {
    // No necesita id, es sólo 1 universo. 

    private ArrayList<Star> universe; 
    // Dentro de Star, lista de Planetas "ArrayList<Star> -> Star -> ArrayList<Planeta>"
    private ArrayList<ArrayList<Integer>> adjancyList; 
    // La infromación del grafo conectado

    private int nodes;
    private int edges;


    public Universe() {
    }

    public Universe(ArrayList<Star> universe, ArrayList<ArrayList<Integer>> adjancyList, int nodes, int edges) {
        this.universe = universe;
        this.adjancyList = adjancyList;
        this.nodes = nodes;
        this.edges = edges;
    }

    public ArrayList<Star> getUniverse() {
        return this.universe;
    }

    public void setUniverse(ArrayList<Star> universe) {
        this.universe = universe;
    }

    public ArrayList<ArrayList<Integer>> getAdjancyList() {
        return this.adjancyList;
    }

    public void setAdjancyList(ArrayList<ArrayList<Integer>> adjancyList) {
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
