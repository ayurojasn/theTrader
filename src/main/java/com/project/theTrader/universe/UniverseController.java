package com.project.theTrader.universe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniverseController {
    
    @Autowired
    UniverseService universeService;

    @GetMapping("/universe") // R -> All
    @CrossOrigin(origins = "http://localhost:4200")
    private List<Universe> getAllStars() {
        return universeService.getAllStars();
    }
}
