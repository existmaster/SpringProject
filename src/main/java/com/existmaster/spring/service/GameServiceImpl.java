package com.existmaster.spring.service;

import com.existmaster.spring.config.GameConfig;
import com.existmaster.spring.model.Game;
import com.existmaster.spring.model.Player;
import com.existmaster.spring.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by existmaster on 2015. 8. 11..
 */
@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gr;

    @Override
    public Game createGame(int playerNum) {
        return gr.save(new Game(playerNum));
    }

    @Override
    public Player createLadder(Game g, Player p) {
        List<Player> players = g.getPlayer();
        for (int time = 0; time < GameConfig.MaxTime; time++) {
            if(Math.random()*100 > GameConfig.PointRate){
                if(p.getPosition() == 0 ||
                        (p.getPosition() > 0 && !players.get(p.getPosition()-1).getPoint().get(time)))
                    p.addPoint(true);
                else
                    p.addPoint(false);
            }
            else
                p.addPoint(false);

        }
        return p;
    }

    @Override
    public int getResult(Game g, Player p) {
        List<Player> players = g.getPlayer();
        int resultObject = p.getPosition();
        for (int time = 0; time < GameConfig.MaxTime; time++) {
            if (resultObject != players.size()-1 &&
                    players.get(resultObject).getPoint().get(time)) {
                resultObject++;
            } else if(resultObject != 0 &&
                    players.get(resultObject - 1).getPoint().get(time)) {
                resultObject--;
            }
        }
        return resultObject;
    }
}
