package com.project.theTrader.product;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.theTrader.productCrew.ProductCrew;
import com.project.theTrader.productPlanet.ProductPlanet;

@Entity
public class Product {
    
    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private double volume;
    private Integer stock;
    private Integer demand;
    private Integer supply;
    private double pv;
    private boolean b_pv;
    private double pc;
    private boolean b_pc;

    public Product() {
    }

    public Product(String productName, double volume, Integer stock, Integer demand, Integer supply, double pv, boolean b_pv, double pc, boolean b_pc) {
        this.productName = productName;
        this.volume = volume;
        this.stock = stock;
        this.demand = demand;
        this.supply = supply;
        this.pv = pv;
        this.b_pv = b_pv;
        this.pc = pc;
        this.b_pc = b_pc;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getVolume() {
        return this.volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getDemand() {
        return this.demand;
    }

    public void setDemand(Integer demand) {
        this.demand = demand;
    }

    public Integer getSupply() {
        return this.supply;
    }

    public void setSupply(Integer supply) {
        this.supply = supply;
    }

    public double getPv() {
        return this.pv;
    }

    public void setPv(double pv) {
        this.pv = pv;
    }

    public boolean isB_pv() {
        return this.b_pv;
    }

    public boolean getB_pv() {
        return this.b_pv;
    }

    public void setB_pv(boolean b_pv) {
        this.b_pv = b_pv;
    }

    public double getPc() {
        return this.pc;
    }

    public void setPc(double pc) {
        this.pc = pc;
    }

    public boolean isB_pc() {
        return this.b_pc;
    }

    public boolean getB_pc() {
        return this.b_pc;
    }

    public void setB_pc(boolean b_pc) {
        this.b_pc = b_pc;
    }


    // public List<ProductPlanet> getProductsPlanet() {
    //     return this.productsPlanet;
    // }

    // public void setProductsPlanet(List<ProductPlanet> productsPlanet) {
    //     this.productsPlanet = productsPlanet;
    // }


    // public List<ProductCrew> getProductsCrew() {
    //     return this.productsCrew;
    // }

    // public void setProductsCrew(List<ProductCrew> productsCrew) {
    //     this.productsCrew = productsCrew;
    // }
 
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", productName='" + getProductName() + "'" +
            ", volume='" + getVolume() + "'" +
            ", stock='" + getStock() + "'" +
            ", demand='" + getDemand() + "'" +
            ", supply='" + getSupply() + "'" +
            ", pv='" + getPv() + "'" +
            ", b_pv='" + isB_pv() + "'" +
            ", pc='" + getPc() + "'" +
            ", b_pc='" + isB_pc() + "'" +
            "}";
    }



}
