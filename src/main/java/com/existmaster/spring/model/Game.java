package com.existmaster.spring.model;

import javax.persistence.*;
import java.util.List;
import java.util.*;

/**
 * Created by existmaster on 2015. 8. 11..
 */
@Entity
public class Game {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gameId;

    @Column(name="player_count")
    private int playerCount;

    @OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="game_id", referencedColumnName = "id")
    private Collection<Player> player;

    public Game() {
    }

    public Game(int playerCount) {
        this.playerCount = playerCount;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public Collection<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public void addPlayer(Player p){
        if(player == null){
            player = new ArrayList<Player>();
        }
        player.add(p);
    }
}
