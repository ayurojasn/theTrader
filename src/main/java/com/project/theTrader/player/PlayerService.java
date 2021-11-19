package com.project.theTrader.player;

import java.util.ArrayList;
import java.util.List;

import com.project.theTrader.crew.Crew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping(consumes = "application/json", produces = "application/json")

public class PlayerService {    

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers(){  
    List<Player> players = new ArrayList<Player>();  
    playerRepository.findAll().forEach(player1 -> players.add(player1));  
    return players;  
    }

    public void create(Player player) {
        playerRepository.save(player);
    }

    public Player getPlayerById(Long playerid) {
        return playerRepository.findById(playerid).get();
    }

    public void delete(Long playerid) {
        playerRepository.deleteById(playerid);
    }

    public void update(Player player, Long playerid) {
        playerRepository.save(player);
    }  

    public Long getCrewPlayer(Long playerid){
        Long crewId;
        Crew crew = new Crew();
        Player playerCrew = new Player();
        playerCrew = getPlayerById(playerid);
        crew = playerCrew.getCrew();
        crewId = crew.getId();

        return crewId;
    }

    public Player getPlayerByName(String playername){
        Player player = new Player();
        List<Player> players = new ArrayList<Player>(); 
        players = getAllPlayers();

        for(int i = 0; i<players.size(); i++){
            if((players.get(i).getUserName()).contentEquals(playername)){
                player = getPlayerById(players.get(i).getId());
            }
        }

        return player;
    }
}
