package com.existmaster.spring.service;

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

    public static int MaxTime = 10;

    @Autowired
    private GameRepository gr;

    @Override
    public Game createGame(int playerNum) {
        return gr.save(new Game(playerNum));
    }

    @Override
    public void createLadder(Player p) {
        for (int time = 0; time < MaxTime; time++) {
            p.addPoint(true);
        }
    }

    @Override
    public int getResult(int playerId) {
        return 0;
    }

    public int getResult(Game g, Player p) {
        List<Player> players = g.getPlayer();
        int resultPoint = p.getId();
        for (int time = 0; time < MaxTime; time++) {
            if (players.get(resultPoint).getPoint().get(time) == true) {
                resultPoint++;
            } else if(players.get(resultPoint - 1).getPoint().get(time) == true) {
                resultPoint--;
            }
        }
        return resultPoint;
    }
}
