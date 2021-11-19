package com.project.theTrader.planet;

import java.util.ArrayList;
import java.util.List;

import com.project.theTrader.productPlanet.ProductPlanet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlanetController {
    
    @Autowired
    PlanetService planetService;

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PostMapping(value="/planet", consumes={"application/json"}) // C
    private Long createPlanet(@RequestBody Planet planet) {
        planetService.create(planet);
        return planet.getId();
    }
    
    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @GetMapping("/planets") // R -> All
    private List<Planet> getAllPlanets() {
        return planetService.getAllPlanets();
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @GetMapping("/planet/{planetid}") // R -> ById
    @CrossOrigin(origins = "http://localhost:4200")
    private Planet getPlanet(@PathVariable("planetid") Long planetid) {
        return planetService.getPlanetById(planetid);
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PutMapping("/planet") // U
    private Planet updatePlanet(@RequestBody Planet planet, Long planetid) {
        planetService.update(planet, planetid);
        return planet;
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @GetMapping("/productPlanet/{planetid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private List<ProductPlanet> getProductPlanet(@PathVariable("planetid") Long planetid){
        return planetService.getProductPlanet(planetid);
    } 

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PutMapping("/removeProductPlanet/{planetid}/{productid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private void removeProductPlanet(@PathVariable("planetid") Long planetid, @PathVariable("productid") Long productid){
        planetService.removeProductPlanet(planetid, productid);
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PutMapping("addProductPlanet/{planetid}/{productid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private void addProductPlanet(@PathVariable("planetid") Long planetid, @PathVariable("productid") Long productid){
        planetService.addProductPlanet(planetid, productid);
    }

}
