package com.project.theTrader.universe;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping(consumes = "application/json", produces = "application/json")

public class UniverseService {

    @Autowired
    UniverseRepository universeRepository;

    public List<Universe> getAllStars(){  
        List<Universe> stars = new ArrayList<Universe>();  
        universeRepository.findAll().forEach(star -> stars.add(star));  
        return stars;  
    }
}
