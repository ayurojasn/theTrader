package com.project.theTrader.productPlanet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPlanetRepository extends CrudRepository<ProductPlanet, Long> {
    
}
