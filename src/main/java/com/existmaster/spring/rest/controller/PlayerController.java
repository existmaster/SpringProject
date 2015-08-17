package com.existmaster.spring.rest.controller;

import com.existmaster.spring.model.Game;
import com.existmaster.spring.model.Player;
import com.existmaster.spring.repository.GameRepository;
import com.existmaster.spring.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by existmaster on 2015. 8. 13..
 */
@Controller
@RequestMapping("/Player")
public class PlayerController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Player createPlayer(@RequestBody Game game, @RequestBody String name){
        Player player = playerRepository.save(new Player(game, name));

        return player;
    }

}
