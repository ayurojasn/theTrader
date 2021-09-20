package com.project.theTrader.productCrew;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.theTrader.crew.Crew;
import com.project.theTrader.product.Product;

@Entity
public class ProductCrew {

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Crew crew;

    public ProductCrew() {
    }

    public ProductCrew(Product product, Crew crew) {
        this.product = product;
        this.crew = crew;
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

    public Crew getCrew() {
        return this.crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", product='" + getProduct() + "'" +
            ", crew='" + getCrew() + "'" +
            "}";
    }

}

