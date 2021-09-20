package com.project.theTrader.productCrew;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCrewRepository extends CrudRepository<ProductCrew, Long>{
    
}
