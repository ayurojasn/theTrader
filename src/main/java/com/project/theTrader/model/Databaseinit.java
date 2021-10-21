package com.project.theTrader.model;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.project.theTrader.crew.Crew;
import com.project.theTrader.crew.CrewRepository;
import com.project.theTrader.planet.Planet;
import com.project.theTrader.planet.PlanetRepository;
import com.project.theTrader.player.Player;
import com.project.theTrader.player.PlayerRepository;
import com.project.theTrader.product.Product;
import com.project.theTrader.product.ProductRepository;
import com.project.theTrader.productCrew.ProductCrew;
import com.project.theTrader.productCrew.ProductCrewRepository;
import com.project.theTrader.productPlanet.ProductPlanet;
import com.project.theTrader.productPlanet.ProductPlanetRepository;
import com.project.theTrader.spacecraft.Spacecraft;
import com.project.theTrader.spacecraft.SpacecraftRepository;
import com.project.theTrader.star.Star;
import com.project.theTrader.star.StarRepository;
import com.project.theTrader.universe.Universe;
import com.project.theTrader.universe.UniverseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Databaseinit implements ApplicationRunner{

    @Autowired
    CrewRepository crewRepository;

    @Autowired
    PlanetRepository planetRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SpacecraftRepository spacecraftRepository;

    @Autowired
    StarRepository starRepository;

    @Autowired
    ProductPlanetRepository productPlanetRepository;

    @Autowired
    ProductCrewRepository productCrewRepository;

    @Autowired
    UniverseRepository universeRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

        // Creando datos para la base de datos

        // Player
        Player p1 = new Player("Obi-Wan", "Captain");
        Player p2 = new Player("Luke", "Pilot");
        Player p3 = new Player("Darth", "Trader");

        // Crew
        Crew crew1 = new Crew("Jedis", 100, 40);
        Crew crew2 = new Crew("Empire", 250, 20);  

        // Spacecraft
        Spacecraft craft1 = new Spacecraft("X-wings", 200, 30);
        Spacecraft craft2 = new Spacecraft("Tie fighters", 400, 50);
        // Spacecraft craft3 = new Spacecraft("Delta 7", 400, 50);

        // Product 
        Product product1 = new Product("Droid1", 30, 10, 5, 5, 20, true, 20, true);
        Product product2 = new Product("Droid2", 30, 10, 5, 5, 20, true, 20, true);
        Product product3 = new Product("Droid3", 30, 10, 5, 5, 20, true, 20, true);

        // Planet 
        Planet planet1 = new Planet("Tatooine");
        Planet planet2 = new Planet("Alderaan");
        Planet planet3 = new Planet("Hoth");

        // Star
        Star star1 = new Star("star1", 1, 1, 1, true);
        Star star2 = new Star("star2", 5, 20, 15, true);
        Star star3 = new Star("star3", 8, 2, 15, true);
        Star star4 = new Star("star4", 3, 10, 7, true);
    
        spacecraftRepository.save(craft1);
        spacecraftRepository.save(craft2);

        planetRepository.save(planet1);
        planetRepository.save(planet2);
        planetRepository.save(planet3);

        
        crewRepository.save(crew1);
        crewRepository.save(crew2);

        
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);


        // Add each Planet in Star
        star1.addPlanet(planet1);
        star1.addPlanet(planet2);
        star2.addPlanet(planet3);

        star1.addSpacecraft(craft1);
        star2.addSpacecraft(craft2);

        // Add each Product in Planet
        planet1.addProduct(product1); //Droide1-5
        planet1.addProduct(product2); //Droide2-5
        planet2.addProduct(product2); //Droide2-6
        planet3.addProduct(product3); //Droide3-7

        // Add each player in crew
        crew1.addPlayer(p1);
        crew1.addPlayer(p2);
        crew2.addPlayer(p3); 

        // Set spacecraft in crew
        crew1.setSpacecraft(craft1);
        crew2.setSpacecraft(craft2);

        craft1.setStar(star1);
        craft2.setStar(star2);
        
        // Add product in crew
        crew1.addProduct(product1);
        crew2.addProduct(product2);
        crew2.addProduct(product3);

        //Save in each repository
        starRepository.save(star1);
        starRepository.save(star2);
        starRepository.save(star3);
        starRepository.save(star4);

        ArrayList<Star> lists = new ArrayList<>();
        lists.add(star1);
        lists.add(star2);
        lists.add(star3);
        lists.add(star4);

        ArrayList<ArrayList<Star>> universeStars = new ArrayList<ArrayList<Star>>();

        ArrayList<Star> star1List = new ArrayList<>();
        star1List.add(star2);
        star1List.add(star3);

        ArrayList<Star> star2List = new ArrayList<>();
        star2List.add(star1);
        star2List.add(star3);

        ArrayList<Star> star3List = new ArrayList<>();
        star3List.add(star1);
        star3List.add(star2);
        star3List.add(star4);

        ArrayList<Star> star4List = new ArrayList<>();
        star4List.add(star3);

        universeStars.add(star1List);
        universeStars.add(star2List);
        universeStars.add(star3List);
        universeStars.add(star4List);

        Universe universe = new Universe(lists, universeStars, 4, 4);

        universeRepository.save(universe);
        
        planetRepository.save(planet1);
        planetRepository.save(planet2);
        planetRepository.save(planet3);

        crewRepository.save(crew1);
        crewRepository.save(crew2);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        
    }
    
}
