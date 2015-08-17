package com.existmaster.spring.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by existmaster on 2015. 8. 11..
 */
@Entity
@Table(name="GAMES")
public class Game{
    @Id
    @Column(name="GAME_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int playerCount;

    @OneToMany(mappedBy = "game")
    private List<Player> players = new ArrayList<Player>();

    @ElementCollection
    private List<String> result = new ArrayList<String>();

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

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
        return players;
    }

    public void setPlayer(List<Player> player) {
        this.players = player;
    }

    public Game() {
    }

    public Game(int playerCount) {
        this.playerCount = playerCount;
    }

    public void addPlayer(Player p){
        players.add(p);
    }
    public void addResult(String s) {result.add(s);}
}
