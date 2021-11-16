package com.project.theTrader.crew;

import java.util.ArrayList;
import java.util.List;

import com.project.theTrader.productCrew.ProductCrew;
import com.project.theTrader.productCrew.ProductCrewRepository;
import com.project.theTrader.product.Product;
import com.project.theTrader.product.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping(consumes = "application/json", produces = "application/json")
public class CrewService {

    @Autowired
    CrewRepository crewRepository;

    @Autowired
    ProductService productService;

    @Autowired
    ProductCrewRepository productCrewRepository;


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

    public void addProductCrew(Long crewid, Long productid){
        List<ProductCrew> productCrewList = new ArrayList<>();
        ProductCrew pc = new ProductCrew();
        Crew crew = new Crew();
        crew = getCrewById(crewid);
        Product product = new Product();
        product = productService.getProductById(productid);
        pc.setCrew(crew);
        pc.setProduct(product);
        productCrewList = crew.getProductCrewList();

        productCrewList.add(pc);
        crew.setProductCrewList(productCrewList);
        crewRepository.save(crew);
    }

    public double getCredits(Long crewid){
        double credits;
        Crew crew = new Crew();
        crew = getCrewById(crewid);
        credits = crew.getCredits();

        return credits;
    }

    public void updateCreditsCompra(Long crewid, double credits){
        System.out.println("===========================================");
        Crew crew = new Crew();
        crew = getCrewById(crewid);
        double currentCredits, newCredits;
        currentCredits = crew.getCredits();
        newCredits = currentCredits - credits;

        crew.setCredits(newCredits);
        crewRepository.save(crew);
    }

    public void updateCreditsVenta(Long crewid, double credits){
        System.out.println("===========================================");
        Crew crew = new Crew();
        crew = getCrewById(crewid);
        double currentCredits, newCredits;
        currentCredits = crew.getCredits();
        newCredits = currentCredits + credits;

        crew.setCredits(newCredits);
        crewRepository.save(crew);
    }

    public void removeProductCrew(Long crewid, Long productid){
        Crew crew = new Crew();
        ProductCrew pp = new ProductCrew();
        crew = getCrewById(crewid);
        List<ProductCrew> productCrewList = new ArrayList<>();
        productCrewList = crew.getProductCrewList();
    
       for(int i=0; i<productCrewList.size();i++){
           Product product = new Product();
           pp = productCrewList.get(i);
           product = pp.getProduct();
           if(product.getId() == productid){
             System.out.println("productPlanet i: " + i + product);
             productCrewList.remove(i);
             break;
           }
       }
       crew.setProductCrewList(productCrewList);
       crewRepository.save(crew);
       productCrewRepository.delete(pp);
       System.out.println(productCrewList);

    }

}