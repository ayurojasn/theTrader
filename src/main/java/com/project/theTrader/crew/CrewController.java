package com.project.theTrader.crew;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrewController {
    
    @Autowired
    CrewService crewService;

    @PostMapping(value="/crew", consumes={"application/json"}) // C
    private Long createCrew(@RequestBody Crew crew) {
        crewService.create(crew);
        return crew.getId();
    }

    @GetMapping("/crews") // R -> All
    private List<Crew> getAllCrews() {
        return crewService.getAllCrews();
    }

    @GetMapping("/crew/{crewid}") // R -> ById
    private Crew getCrew(@PathVariable("crewid") Long crewid) {
        return crewService.getPlayerById(crewid);
    }

    @PutMapping("/crew") // U
    private Crew updateCrew(@RequestBody Crew crew, Long crewid) {
        crewService.update(crew, crewid);
        return crew;
    }
    
    @DeleteMapping("/crew/{crewid}") // D
    private void deleteCrew(@PathVariable("crewid") Long crewid) {
        crewService.delete(crewid);
    }
}
