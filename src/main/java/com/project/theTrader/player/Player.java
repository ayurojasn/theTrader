package com.project.theTrader.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;
    private String playerName;
    private String role;


    public Player() {
    }

    public Player(String playerName, String role) {
        this.playerName = playerName;
        this.role = role;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
  
    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", playerName='" + getPlayerName() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }


}
