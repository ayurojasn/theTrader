package com.project.theTrader.planet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping(consumes = "application/json", produces = "application/json")

public class PlanetService {
    
    @Autowired
    PlanetRepository planetRepository;

    public void create(Planet planet) {
        planetRepository.save(planet);
    }

    public List<Planet> getAllPlanets(){  
    List<Planet> planets = new ArrayList<Planet>();  
    planetRepository.findAll().forEach(planet1 -> planets.add(planet1));  
    return planets;  
    }

    public Planet getPlayerById(Long planetid) {
        return planetRepository.findById(planetid).get();
    }

    public void update(Planet planet, Long planetid) {
        planetRepository.save(planet);
    }

}
