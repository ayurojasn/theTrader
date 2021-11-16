package com.project.theTrader.productPlanet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.project.theTrader.product.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.theTrader.planet.Planet;

@Entity
public class ProductPlanet {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Product product;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference("productPlanet")
    private Planet planet;

    public ProductPlanet() {
    }

    public ProductPlanet(Product product, Planet planet) {
        this.product = product;
        this.planet = planet;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Planet getPlanet() {
        return this.planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", product='" + getProduct() + "'" +
            ", planet='" + getPlanet() + "'" +
            "}";
    }


}
