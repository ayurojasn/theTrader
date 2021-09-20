package com.project.theTrader.planet;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.project.theTrader.product.Product;
import com.project.theTrader.productPlanet.ProductPlanet;
import com.project.theTrader.star.Star;

@Entity
public class Planet {

    @Id
    @GeneratedValue
    private Long id;
    private String planetName;

    @ManyToOne
    private Star star;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planet")
    @JsonManagedReference(value = "planet-product")
    private List<ProductPlanet> productPlanetList = new ArrayList<>();



    public Planet() {
    }

    public Planet(String planetName) {
        this.planetName = planetName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanetName() {
        return this.planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public List<ProductPlanet> getProductList() {
        return this.productPlanetList;
    }

    public void setProductList(List<ProductPlanet> productPlanetList) {
        this.productPlanetList = productPlanetList;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", planetName='" + getPlanetName() + "'" +
            "}";
    }

    //Add product in productlist in Planet -> Products in Planet

    public void addProduct(Product product) {
        ProductPlanet productP = new ProductPlanet(product, this);
        productPlanetList.add(productP);
        product.getProductsPlanet().add(productP);
    }

}
