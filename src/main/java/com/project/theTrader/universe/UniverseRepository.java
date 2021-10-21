package com.project.theTrader.universe;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniverseRepository extends CrudRepository<Universe, Long>{
    
}
