package com.existmaster.spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by existmaster on 2015. 8. 11..
 */
@Entity
public class Player {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int playerId;

    @ManyToOne
    @JsonBackReference
    private Game game;
    //private int gameId;

    @Column(name="name")
    private String name;

    //@ElementCollection
//    @CollectionTable(
//            name="LADDER",
//            joinColumns = @JoinColumn(name="player_id")
//    )
//    @Column(name="active_time")
//    private List<Integer> ladder;

    public Player() {
    }

    public Player(Game game, String name) {
        this.game = game;
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Integer> getLadder() {
//        return ladder;
//    }
//
//    public void setLadder(List<Integer> ladder) {
//        this.ladder = ladder;
//    }
//
//    public void addLadder(int p){
//        if(ladder == null){
//            ladder = new ArrayList<Integer>();
//        }
//        ladder.add(p);
//    }
}
