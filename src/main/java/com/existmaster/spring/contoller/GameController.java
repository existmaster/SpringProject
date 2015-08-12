package com.existmaster.spring.contoller;

import com.existmaster.spring.model.Game;
import com.existmaster.spring.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by existmaster on 2015. 8. 12..
 */
@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameRepository gr;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Game> getGames(){
        List<Game> games = gr.findAll();
        return games;
    }



}
