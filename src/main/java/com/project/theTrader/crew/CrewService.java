package com.project.theTrader.crew;

import java.util.ArrayList;
import java.util.List;

import com.project.theTrader.productCrew.ProductCrew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping(consumes = "application/json", produces = "application/json")
public class CrewService {

    @Autowired
    CrewRepository crewRepository;

    public void create(Crew crew) {
        crewRepository.save(crew);
    }

    public List<Crew> getAllCrews() {
        List<Crew> crews = new ArrayList<Crew>();
        crewRepository.findAll().forEach(crew1 -> crews.add(crew1));
        return crews;
    }

    public Crew getCrewById(Long crewid) {
        return crewRepository.findById(crewid).get();
    }

    public void update(Crew crew, Long crewid) {
        crewRepository.save(crew);
    }

    public void delete(Long crewid) {
        crewRepository.deleteById(crewid);
    }

    public void updateTimeCrew(Long crewid, Integer time){
        Crew crew = new Crew();
        crew = getCrewById(crewid);
        Integer currentTime, calculatedTime;
        currentTime = crew.getTotalTime();
        calculatedTime = currentTime - time;
        crew.setTotalTime(calculatedTime);

        crewRepository.save(crew);
    }

    public List<ProductCrew> getProductCrew(Long crewid){
        List<ProductCrew> productCrewList = new ArrayList<>();
        Crew crew = new Crew();
        crew = getCrewById(crewid);
        productCrewList = crew.getProductCrewList();

        return productCrewList;
    }

}