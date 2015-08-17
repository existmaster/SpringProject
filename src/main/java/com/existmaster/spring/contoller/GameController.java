package com.existmaster.spring.contoller;

import com.existmaster.spring.model.Game;
import com.existmaster.spring.model.Player;
import com.existmaster.spring.repository.GameRepository;
import com.existmaster.spring.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by existmaster on 2015. 8. 12..
 */
@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameRepository gr;

    @Autowired
    private PlayerRepository pr;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@ModelAttribute("game") Game game, Model model){
    //public Game createGame(HttpServletRequest request, HttpServletResponse response){
        //Game game = new Game(5);
        gr.save(game);
        return game;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Game> getGames(){
        List<Game> games = gr.findAll();
        return games;
    }


    //@RequestMapping("/p")
    public List<Player> getPlayers(){
        List<Player> player = pr.findAll();
        return player;
    }

    //@RequestMapping("/c")
    public String createDate(){
        Game game = gr.save(new Game(3));
        Player player = pr.save(new Player(game, "ABC"));
        return "Success";
    }


}
