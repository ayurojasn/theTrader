package com.project.theTrader.crew;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CrewRepository extends CrudRepository<Crew, Long> {
    
}
