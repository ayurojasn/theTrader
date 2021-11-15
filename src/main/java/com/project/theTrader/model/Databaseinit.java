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
        Spacecraft craft1 = new Spacecraft("X-wings", 200, 100);
        Spacecraft craft2 = new Spacecraft("Tie fighters", 400, 120);
        // Spacecraft craft3 = new Spacecraft("Delta 7", 400, 50);

        // Product 
        Product product1 = new Product("Droid1", 30, 10, 5, 5, 20, true, 20, true);
        Product product2 = new Product("Droid2", 30, 10, 5, 5, 20, true, 20, true);
        Product product3 = new Product("Droid3", 30, 10, 5, 5, 20, true, 20, true);

        // Planet 
        Planet planet1 = new Planet("Tatooine");
        Planet planet2 = new Planet("Alderaan");
        Planet planet3 = new Planet("Hoth");
        Planet planet4 = new Planet("Kamino");
        Planet planet5 = new Planet("Bespin");
        Planet planet6 = new Planet("Cato Neimoidia");

        // Star
        Star star0 = new Star("Polaris", 1, 1, 1, true, 0);
        Star star1 = new Star("Sirius", 5, 20, 15, true, 1);
        Star star2 = new Star("Rigel", 8, 2, 15, true, 2);
        Star star3 = new Star("Vega", 3, 10, 7, true, 3);
        Star star4 = new Star("Pleiades", 3, 10, 7, true, 4);
        Star star5 = new Star("Antares", 3, 10, 7, true, 5);
        Star star6 = new Star("Canopus", 3, 10, 7, true, 6);
        Star star7 = new Star("Altair", 3, 10, 7, true, 7);
        Star star8 = new Star("Aldebaran", 3, 10, 7, true, 8);
        Star star9 = new Star("Spica", 3, 10, 7, true, 9);
        Star star10 = new Star("Mimosa", 3, 10, 7, true, 10);
        Star star11 = new Star("Pollux", 3, 10, 7, true, 11);
        Star star12 = new Star("Deneb", 3, 10, 7, true, 12);
        Star star13 = new Star("Bellatrix", 3, 10, 7, true, 13);
        

        spacecraftRepository.save(craft1);
        spacecraftRepository.save(craft2);

        planetRepository.save(planet1);
        planetRepository.save(planet2);
        planetRepository.save(planet3);
        planetRepository.save(planet4);
        planetRepository.save(planet5);
        planetRepository.save(planet6);
        
        crewRepository.save(crew1);
        crewRepository.save(crew2);

        
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);


        // Add each Planet in Star
        star1.addPlanet(planet1);
        star1.addPlanet(planet2);
        star2.addPlanet(planet3);
        star3.addPlanet(planet4);
        star3.addPlanet(planet5);
        star4.addPlanet(planet6);



        star1.addSpacecraft(craft1);
        star2.addSpacecraft(craft2);

        // Add each Product in Planet
        planet1.addProduct(product1); //Droide1-5
        planet1.addProduct(product2); //Droide2-5
        planet2.addProduct(product2); //Droide2-6
        planet3.addProduct(product3); //Droide3-7

        // Add each player in crew
        crew1.addPlayer(p2);
        crew1.addPlayer(p3);
        crew2.addPlayer(p1); 

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
        starRepository.save(star0);
        starRepository.save(star1);
        starRepository.save(star2);
        starRepository.save(star3);
        starRepository.save(star4);
        starRepository.save(star5);
        starRepository.save(star6);
        starRepository.save(star7);
        starRepository.save(star8);
        starRepository.save(star9);
        starRepository.save(star10);
        starRepository.save(star11);
        starRepository.save(star12);
        starRepository.save(star13);
        

     
        Universe universe = new Universe(14);

        universe.setNodes(14);
        
        universe.addStar(star0);
        universe.addStar(star1);
        universe.addStar(star2);
        universe.addStar(star3);
        universe.addStar(star4);
        universe.addStar(star5);
        universe.addStar(star6);
        universe.addStar(star7);
        universe.addStar(star8);
        universe.addStar(star9);
        universe.addStar(star10);
        universe.addStar(star11);
        universe.addStar(star12);
        universe.addStar(star13);

        // universe.addEdgesStars();


        universeRepository.save(universe);
        
        // universe.addEdgesStars();

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
