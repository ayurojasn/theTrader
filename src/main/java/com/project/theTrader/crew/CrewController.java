package com.project.theTrader.crew;

import java.util.List;

import com.project.theTrader.productCrew.ProductCrew;

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
public class CrewController {
    
    @Autowired
    CrewService crewService;

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PostMapping(value="/crew", consumes={"application/json"}) // C
    private Long createCrew(@RequestBody Crew crew) {
        crewService.create(crew);
        return crew.getId();
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @GetMapping("/crews") // R -> All
    private List<Crew> getAllCrews() {
        return crewService.getAllCrews();
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @GetMapping("/crew/{crewid}") // R -> ById
    @CrossOrigin(origins = "http://localhost:4200")
    private Crew getCrew(@PathVariable("crewid") Long crewid) {
        return crewService.getCrewById(crewid);
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PutMapping("/crew") // U
    private Crew updateCrew(@RequestBody Crew crew, Long crewid) {
        crewService.update(crew, crewid);
        return crew;
    }
    
    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @DeleteMapping("/crew/{crewid}") // D
    private void deleteCrew(@PathVariable("crewid") Long crewid) {
        crewService.delete(crewid);
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PutMapping("crewPlayerTime/{crewid}/{time}")
    @CrossOrigin(origins = "http://localhost:4200")
    private void updateTimeCrew(@PathVariable("crewid") Long crewid, @PathVariable("time") Integer time){
        crewService.updateTimeCrew(crewid, time);
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @GetMapping("/productCrew/{crewid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private List<ProductCrew> getProductCrew(@PathVariable("crewid") Long crewid){
        return crewService.getProductCrew(crewid);
    } 

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PutMapping("addProductCrew/{crewid}/{productid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private void addProductCrew(@PathVariable("crewid") Long crewid, @PathVariable("productid") Long productid){
        crewService.addProductCrew(crewid, productid);
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @GetMapping("credits/{crewid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private double getCredits(@PathVariable("crewid") Long crewid){
        return crewService.getCredits(crewid);
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PutMapping("updateCreditsCompra/{crewid}/{credits}")
    @CrossOrigin(origins = "http://localhost:4200")
    private void updateCreditsCompra(@PathVariable("crewid") Long crewid, @PathVariable("credits") Long credits){
        crewService.updateCreditsCompra(crewid, credits);
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PutMapping("updateCreditsVenta/{crewid}/{credits}")
    @CrossOrigin(origins = "http://localhost:4200")
    private void updateCreditsVenta(@PathVariable("crewid") Long crewid, @PathVariable("credits") Long credits){
        crewService.updateCreditsVenta(crewid, credits);
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PutMapping("/removeProductCrew/{crewid}/{productid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private void removeProductCreww(@PathVariable("crewid") Long crewid, @PathVariable("productid") Long productid){
        crewService.removeProductCrew(crewid, productid);
    }

}
