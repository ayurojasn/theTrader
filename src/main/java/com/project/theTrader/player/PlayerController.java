package com.project.theTrader.player;

import java.util.ArrayList;
import java.util.List;


import com.project.theTrader.crew.Crew;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {

    // CRUD -> Create - Read - Update - Delete
    // ~~ Post - Get - Put - Delete

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    PlayerService playerService;

    @PostMapping(value="/player", consumes={"application/json"}) // C
    private Long createPlayer(@RequestBody Player player) {
        playerService.create(player);
        return player.getId();
    }

    @GetMapping("/players") // R -> All
    @CrossOrigin(origins = "http://localhost:4200")
    private List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/player/{playerid}") // R -> ById
    @CrossOrigin(origins = "http://localhost:4200")
    private Player getPlayer(@PathVariable("playerid") Long playerid) {
        return playerService.getPlayerById(playerid);
    }

    @PutMapping("/player") // U
    private Player updatePlayer(@RequestBody Player player, Long playerid) {
        playerService.update(player, playerid);
        return player;
    }

    @DeleteMapping("/player/{playerid}") // D
    private void deletePlayer(@PathVariable("playerid") Long playerid) {
        playerService.delete(playerid);
    }

    @GetMapping("crewPlayer/{playerid}")
    @CrossOrigin(origins = "http://localhost:4200")
    private Long getCrewPlayer(@PathVariable("playerid") Long playerid){
        return playerService.getCrewPlayer(playerid);
    }

}
