package com.existmaster.test;

import com.existmaster.spring.Application;
import com.existmaster.spring.model.Game;
import com.existmaster.spring.model.Player;
import com.existmaster.spring.model.User;
import com.existmaster.spring.repository.GameRepository;
import com.existmaster.spring.repository.PlayerRepository;
import com.existmaster.spring.repository.UserRepository;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by existmaster on 2015. 8. 11..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
//For server port Integration
@IntegrationTest("server.port:0")
public class LadderJUnitTest {


    @Autowired
    UserRepository userRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;

    Game game1;
    Game game2;
    Game game3;

    Player player1;
    Player player2;

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() {

        game1 = new Game(1);
        game2 = new Game(3);
        game3 = new Game(3);

        gameRepository.deleteAll();
        gameRepository.save(Arrays.asList(game1, game2, game3));

        RestAssured.port = port;
    }

    @Test
    public void canSaveGame() {
        Game game4 = new Game(3);
        Game game5 = gameRepository.save(game4);

        assertNotNull(gameRepository.findOne(game5.getGameId()));

    }

    @Test
    public void canSavePlayer() {

        Game testGame = gameRepository.save(new Game(2));

        playerRepository.save(new Player(testGame, "AAA"));

        //testGame2.addPlayer(new Player(testGame2, "AAA"));
        //testGame2.addPlayer(new Player("BBB"));

        //gameRepository.save(testGame);

        List<Game> list = gameRepository.findAll();

        assertEquals(list.get(3).getPlayer().size(),1);
    }

//    @Test
//    public void canSaveUser() {
//        User user4 = new User("test", "1111", "중성", "바부", "1234@pineone.com");
//
//        when().
//                get("user/add?userId={userId}&password={password}&sex={sex}&nickname={nickname}&email={email}",
//                        user4.getUserId(), user4.getPassword(), user4.getSex(), user4.getNickname(), user4.getEmail()).
//                then().
//                contentType(ContentType.JSON).
//                statusCode(HttpStatus.SC_OK).
//                body("userId", equalTo(user4.getUserId()));
//    }
//
//    @Test
//    public void canFetchUser1() {
//        String user1Id = user1.getUserId();
//
//        when().
//                get("user/search/{userId}", user1Id).
//                then().
//                contentType(ContentType.JSON).
//                statusCode(HttpStatus.SC_OK).
//                body("userId", equalTo(user1Id));
//    }

}
