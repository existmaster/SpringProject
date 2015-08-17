package com.existmaster.spring.service;

import com.existmaster.spring.model.Game;
import com.existmaster.spring.model.Player;

/**
 * Created by existmaster on 2015. 8. 11..
 */
public interface GameService {

    /*
     * 게임을 생성한다.
     */

    Game createGame(int playerNum);

    /*
     * 사다리를 생성한다.
     */

    Player createLadder(Game game, Player player);

    /*
     * 사다리 결과 값을 반환한다.
     */

    int getResult(Game game, Player player);

}
