package com.project.theTrader.planet;

import java.util.ArrayList;
import java.util.List;

import com.project.theTrader.product.Product;
import com.project.theTrader.product.ProductService;
import com.project.theTrader.productPlanet.ProductPlanet;
import com.project.theTrader.productPlanet.ProductPlanetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping(consumes = "application/json", produces = "application/json")

public class PlanetService {
    
    @Autowired
    PlanetRepository planetRepository;

    @Autowired
    ProductPlanetRepository productPlanetRepository;
    
    @Autowired
    ProductService productService;

    public void create(Planet planet) {
        planetRepository.save(planet);
    }

    public List<Planet> getAllPlanets(){  
    List<Planet> planets = new ArrayList<Planet>();  
    planetRepository.findAll().forEach(planet1 -> planets.add(planet1));  
    return planets;  
    }

    public Planet getPlanetById(Long planetid) {
        return planetRepository.findById(planetid).get();
    }

    public void update(Planet planet, Long planetid) {
        planetRepository.save(planet);
    }

    public List<ProductPlanet> getProductPlanet(Long planetid){
        List<ProductPlanet> productPlanetList = new ArrayList<>();
        Planet planet = new Planet();
        planet = getPlanetById(planetid);
        productPlanetList = planet.getProductList();

        return productPlanetList;
    }

    public void removeProductPlanet(Long planetid, Long productid){
        Planet planet = new Planet();
        ProductPlanet pp = new ProductPlanet();
        planet = getPlanetById(planetid);
        List<ProductPlanet> productPlanetList = new ArrayList<>();
        productPlanetList = planet.getProductList();
    
       for(int i=0; i<productPlanetList.size();i++){
           Product product = new Product();
           pp = productPlanetList.get(i);
           product = pp.getProduct();
           if(product.getId() == productid){
             System.out.println("productPlanet i: " + i + product);
             productPlanetList.remove(i);
             break;
           }
       }
       planet.setProductList(productPlanetList);
       planetRepository.save(planet);
       productPlanetRepository.delete(pp);
       System.out.println(productPlanetList);

    }

    public void addProductPlanet(Long planetid, Long productid){
        List<ProductPlanet> productPlanetList = new ArrayList<>();
        ProductPlanet pp = new ProductPlanet();
        Planet planet = new Planet();
        planet = getPlanetById(planetid);
        Product product = new Product();
        product = productService.getProductById(productid);
        pp.setPlanet(planet);
        pp.setProduct(product);
        productPlanetList = planet.getProductList();

        productPlanetList.add(pp);
        planet.setProductList(productPlanetList);
        planetRepository.save(planet);
    }
}
