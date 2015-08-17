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
@Table(name="PLAYERS")
public class Player {

    @Id
    @Column(name="PLAYER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private int position;

    @ManyToOne()
    @JoinColumn(name="GAME_ID")
    @JsonBackReference
    private Game game;

    @Column
    private String name;

    @Column
    private int result;

    @ElementCollection
    private List<Boolean> point = new ArrayList<Boolean>();

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

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

    public Player(int position, Game game) {
        setPosition(position);
        setGame(game);
    }

    public Player(Game game, String name) {
        setGame(game);
        setName(name);
    }

    public Player(int position, Game game, String name) {
        this.position = position;
        this.game = game;
        this.name = name;
    }

    private void setGame(Game game){
        this.game = game;
        game.addPlayer(this);
    }

    public Game getGame() {
        return game;
    }

    public String getName() {
        return name;
    }

    private void setName(String name){
        this.name = name;
    }

    public void addPoint(boolean p){
        point.add(p);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
