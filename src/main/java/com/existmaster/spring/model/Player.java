package com.existmaster.spring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

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
    private int id;

    @ManyToOne
    @JsonBackReference
    private Game game;
    //private int gameId;

    @Column(name="name")
    private String name;

    @OneToMany
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private List<Ladder> ladder;

    @Column
    private List<Boolean> point;

    public List<Boolean> getPoint() {
        return point;
    }

    public void setPoint(List<Boolean> point) {
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Player() {
    }

    public Player(Game game, String name) {
        setGame(game);
        setName(name);
    }

    private void setGame(Game game){
        this.game = game;
        game.addPlayer(this);
    }

    private void setName(String name){
        this.name = name;
    }

    public List<Ladder> getLadder() {
        return ladder;
    }

    public void setLadder(List<Ladder> ladder) {
        this.ladder = ladder;
    }
    public void addPoint(boolean p){
        point.add(p);
    }
    public void addLadder(Ladder p){
        if(ladder == null){
            ladder = new ArrayList<Ladder>();
        }
        ladder.add(p);
    }
}
