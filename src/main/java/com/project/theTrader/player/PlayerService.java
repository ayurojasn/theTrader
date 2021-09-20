package com.project.theTrader.player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequestMapping(consumes = "application/json", produces = "application/json")

public class PlayerService {    

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getAllPlayers()   
    {  
    List<Player> players = new ArrayList<Player>();  
    playerRepository.findAll().forEach(player1 -> players.add(player1));  
    return players;  
    }

    public void create(Player player) {
        Player playerNew = new Player();
        playerNew.setId(player.getId());
        playerNew.setPlayerName(player.getPlayerName());
        playerNew.setRole(player.getRole());
        playerNew.setCrew(player.getCrew());
        playerRepository.save(playerNew);
    }

    public Player getPlayerById(Long playerid) {
        return playerRepository.findById(playerid).get();
    }

    public void delete(Long playerid) {
        playerRepository.deleteById(playerid);
    }

    public void update(Player player, Long playerid) {
        Player playerNew = new Player();
        playerNew.setId(player.getId());
        playerNew.setPlayerName(player.getPlayerName());
        playerNew.setRole(player.getRole());
        playerNew.setCrew(player.getCrew());
        playerRepository.save(playerNew);
    }  
}
