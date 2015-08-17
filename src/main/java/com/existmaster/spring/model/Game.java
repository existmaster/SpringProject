package com.existmaster.spring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by existmaster on 2015. 8. 11..
 */
@Entity
public class Game{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int playerCount;

    @OneToMany(mappedBy = "game")
    private List<Player> player = new ArrayList<Player>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public Game() {
    }

    public Game(int playerCount) {
        this.playerCount = playerCount;
    }

    public void addPlayer(Player p){
        player.add(p);
    }
}
