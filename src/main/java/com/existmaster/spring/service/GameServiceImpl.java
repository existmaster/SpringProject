package com.existmaster.spring.service;

import com.existmaster.spring.model.Game;
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
    public Game createLadder(int id) {
        return null;
    }

    @Override
    public int getResult(int playerId) {
        return 0;
    }
}
