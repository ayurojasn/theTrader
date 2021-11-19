package com.project.theTrader.spacecraft;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class SpacecraftController {

    @Autowired
    SpacecraftService spacecraftService;

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PostMapping(value="/craft", consumes={"application/json"}) // C
    private Long createCraft(@RequestBody Spacecraft craft) {
        spacecraftService.create(craft);
        return craft.getId();
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @GetMapping("/crafts") // R -> All
    private List<Spacecraft> getAllCrafts() {
        return spacecraftService.getAllCrafts();
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @GetMapping("/craft/{craftid}") // R -> ById
    private Spacecraft getCraft(@PathVariable("craftid") Long craftid) {
        return spacecraftService.getCraftById(craftid);
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @PutMapping("/craft") // U
    private Spacecraft updateCraft(@RequestBody Spacecraft craft, Long craftid) {
        spacecraftService.update(craft, craftid);
        return craft;
    }

    // @PreAuthorize(value = "hasRole('ROLE_CAPTAIN')")
    @DeleteMapping("/craft/{craftid}") // D
    private void deleteCraft(@PathVariable("craftid") Long craftid) {
        spacecraftService.delete(craftid);
    }
    
}
