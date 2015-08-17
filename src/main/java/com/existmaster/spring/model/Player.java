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

    @Column(name="name")
    private String name;

    @ElementCollection
    private List<Boolean> point = new ArrayList<Boolean>();

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

    public void addPoint(boolean p){
        point.add(p);
    }

}
