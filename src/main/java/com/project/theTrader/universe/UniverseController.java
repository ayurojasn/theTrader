package com.project.theTrader.universe;

import java.util.List;
import java.util.Vector;

import com.project.theTrader.star.Star;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UniverseController {
    
    @Autowired
    UniverseService universeService;

    // @PreAuthorize("hasRole('ROLE_CAPTAIN')")
    @GetMapping("/universe") // R -> All
    @CrossOrigin(origins = "http://localhost:4200")
    private List<Universe> getAllStars() {
        return universeService.getAllStars();
    }

    // @PreAuthorize("hasRole('ROLE_CAPTAIN')")
    @GetMapping("/graph") 
    @CrossOrigin(origins = "http://localhost:4200")
    private Vector<Vector <Integer>> createGraph(){
        return universeService.createGraph();
    }

    // @PreAuthorize("hasRole('ROLE_CAPTAIN')")
    @GetMapping("/nearby/{starid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private List<Star> nearbyStars(@PathVariable("starid") Long starId){
        return universeService.nearbyStars(starId);
    }


}
