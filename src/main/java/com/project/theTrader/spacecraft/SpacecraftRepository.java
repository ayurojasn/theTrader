package com.project.theTrader.spacecraft;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpacecraftRepository extends CrudRepository<Spacecraft, Long>{
    
}
