package com.existmaster.spring.contoller;

import com.existmaster.spring.model.Game;
import com.existmaster.spring.model.Player;
import com.existmaster.spring.repository.GameRepository;
import com.existmaster.spring.repository.PlayerRepository;
import com.existmaster.spring.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by existmaster on 2015. 8. 17..
 */
@Controller
public class GameController {

    @Autowired
    GameService gameService;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;

    @RequestMapping("game/home")
    public String home(){
        return "game/home";
    }

    //@ResponseBody
    @RequestMapping(value = "game/newGame", method = RequestMethod.POST)
    public String newGame(Game game, Model model){
        Game g = gameRepository.save(game);

//        for(int i=0;i<g.getPlayerCount();i++){
//            playerRepository.save(new Player(i, g));
//        }

        model.addAttribute("game", g);

        //return g;
        return "game/newPlayerForm";
    }
    //@ResponseBody
    @RequestMapping(value = "game/newPlayer")
    public String newPlayerForm(@RequestParam(value="name") List<String> names,
                              Game game, Model model){

        Game g = gameRepository.findOne(game.getId());
        for(int i = 0; i < names.size(); i++) {
            playerRepository.save(new Player(i,g,names.get(i)));
        }
        //Game result = gameRepository.save(g);
//        Game g = gameRepository.findOne(game.getId());
//        for(int i=0;i<g.getPlayerCount();i++)
//        {
//            playerRepository.save(new Player(i, g, game.getPlayer().get(i).getName()));
//        }
//        Game result = gameRepository.save(g);
//        model.addAttribute("game", result);

        return "game/newLadder";
    }

    @ResponseBody
    @RequestMapping(value = "game/newLadder")
    public Game newLadder(Game game){
        Game g = gameRepository.findOne(game.getId());

        for(int i = 0; i < g.getPlayer().size();i++){
            playerRepository.save(gameService.createLadder(g.getPlayer().get(i)));
        }

        return g;

    }
}
