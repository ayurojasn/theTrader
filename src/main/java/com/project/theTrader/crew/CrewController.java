package com.project.theTrader.crew;

import java.util.List;

import com.project.theTrader.productCrew.ProductCrew;

import org.springframework.beans.factory.annotation.Autowired;
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
    @CrossOrigin(origins = "http://localhost:4200")
    private Crew getCrew(@PathVariable("crewid") Long crewid) {
        return crewService.getCrewById(crewid);
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

    @PutMapping("crewPlayerTime/{crewid}/{time}")
    @CrossOrigin(origins = "http://localhost:4200")
    private void updateTimeCrew(@PathVariable("crewid") Long crewid, @PathVariable("time") Integer time){
        crewService.updateTimeCrew(crewid, time);
    }

    @GetMapping("/productCrew/{crewid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private List<ProductCrew> getProductCrew(@PathVariable("crewid") Long crewid){
        return crewService.getProductCrew(crewid);
    } 

    @PutMapping("addProductCrew/{crewid}/{productid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private void addProductCrew(@PathVariable("crewid") Long crewid, @PathVariable("productid") Long productid){
        crewService.addProductCrew(crewid, productid);
    }

    @GetMapping("credits/{crewid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private double getCredits(@PathVariable("crewid") Long crewid){
        return crewService.getCredits(crewid);
    }

    @PutMapping("updateCreditsCompra/{crewid}/{credits}")
    @CrossOrigin(origins = "http://localhost:4200")
    private void updateCreditsCompra(@PathVariable("crewid") Long crewid, @PathVariable("credits") Long credits){
        crewService.updateCreditsCompra(crewid, credits);
    }

    
    @PutMapping("updateCreditsVenta/{crewid}/{credits}")
    @CrossOrigin(origins = "http://localhost:4200")
    private void updateCreditsVenta(@PathVariable("crewid") Long crewid, @PathVariable("credits") Long credits){
        crewService.updateCreditsVenta(crewid, credits);
    }

    @PutMapping("/removeProductCrew/{crewid}/{productid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private void removeProductCreww(@PathVariable("crewid") Long crewid, @PathVariable("productid") Long productid){
        crewService.removeProductCrew(crewid, productid);
    }

}
