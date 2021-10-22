package com.project.theTrader.star;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarController {
    
    @Autowired
    StarService starService;

    @GetMapping("/stars")
    @CrossOrigin(origins = "http://localhost:4200")
    private List<Star> getAll(){
        return starService.getAll();
    }

    @GetMapping("/star/{starid}") // R -> ById
    @CrossOrigin(origins = "http://localhost:4200")
    private Star getPlayer(@PathVariable("starid") Long starid) {
        return starService.getStarById(starid);
    }


}
