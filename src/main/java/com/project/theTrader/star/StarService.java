package com.project.theTrader.star;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping(consumes = "application/json", produces = "application/json")
public class StarService {
    
    @Autowired
    StarRepository starRepository;

    public List<Star> getAll(){
        List<Star> stars = new ArrayList<Star>();
        starRepository.findAll().forEach(star -> stars.add(star));
        return stars;
    }

    public Star getStarById(Long starid) {
        return starRepository.findById(starid).get();
    }
}
