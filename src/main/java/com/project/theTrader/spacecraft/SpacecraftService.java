package com.project.theTrader.spacecraft;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping(consumes = "application/json", produces = "application/json")

public class SpacecraftService {
    
    @Autowired
    SpacecraftRepository spacecraftRepository;

    public List<Spacecraft> getAllCrafts(){  
        List<Spacecraft> crafts = new ArrayList<Spacecraft>();  
        spacecraftRepository.findAll().forEach(craft1 -> crafts.add(craft1));  
        return crafts;  
        }
    
        public void create(Spacecraft craft) {
            spacecraftRepository.save(craft);
        }
    
        public Spacecraft getCraftById(Long craftid) {
            return spacecraftRepository.findById(craftid).get();
        }
    
        public void delete(Long craftid) {
            spacecraftRepository.deleteById(craftid);
        }
    
        public void update(Spacecraft craft, Long craftid) {
            spacecraftRepository.save(craft);
        }  
}
