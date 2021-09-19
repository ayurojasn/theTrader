package com.project.theTrader.model;

import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Databaseinit implements ApplicationRunner{

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        // TODO Auto-generated method stub
        
    }
    
}
