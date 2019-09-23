/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessthenumber.daos;

import java.util.List;
import com.sg.guessthenumber.dto.Game;
import com.sg.guessthenumber.dto.Round;
import java.time.LocalDateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author seanking
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GameDaoTest {
    @Autowired
    GameDao gameDB;
    
    @Autowired
    RoundDao roundDB;
    
    public GameDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List <Game> g = gameDB.getAllGames();
        for(Game play: g){
            gameDB.getGameById(play.getId());
            gameDB.deleteGame(play.getId());
        }
        
         List <Round> r = roundDB.getAllRounds(1);        
        for(Round round: r){
           roundDB.getRoundById(round.getId());
           roundDB.deleteRoundById(round.getId());
        }
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void testAddGetGameById() {
        Game game = new Game();
        game.setAnswer("2321");
        gameDB.createGame(game);
        Game fromDao = gameDB.getGameById(game.getId());
        
        assertEquals(game, fromDao);
    }

    /**
     * Test of getAllGames method, of class GameDao.
     */
    @Test
    public void testGetAllGames() {
        Game game = new Game();
        game.setAnswer("2321");
        gameDB.createGame(game);
        
        Game game2 = new Game();
        game2.setAnswer("3452");
        gameDB.createGame(game2);
        
        List <Game> games = gameDB.getAllGames();
        assertEquals(2, games.size());
        assertTrue(games.contains(game));
        assertTrue(games.contains(game2));
        
        
    }

    /**
     * Test of updateGame method, of class GameDao.
     */
    @Test
    public void testUpdateGame() {
        Game game = new Game();
        game.setAnswer("2321");
        gameDB.createGame(game);
        
        Game fromDao = gameDB.getGameById(game.getId());
        assertEquals(game, fromDao);
        
        game.setSolved(true);
        gameDB.updateGame(game);
        
        assertNotEquals(game, fromDao);
        
        fromDao = gameDB.getGameById(game.getId());
        assertEquals(game, fromDao);
    }

    /**
     * Test of deleteGame method, of class GameDao.
     */
    @Test
    public void testDeleteGame() {
//        Game game = new Game();
//        game.setAnswer("2321");
//        gameDB.createGame(game);
//        
//        Round round = new Round();
//        round.setGameId(game.getId());
//        round.setTime(LocalDateTime.now().withNano(0));
//        round.setUserGuess("2343");
//        round.setResult("e:4");
//        roundDB.addNewRound(round);
//        
//        Game fromDao = gameDB.getGameById(game.getId());
//        roundDB.deleteRoundById(round.getId());
//        gameDB.deleteGame(game.getId());
//        
//        fromDao = gameDB.getGameById(game.getId());
//        assertNull(fromDao);
    }

    
}
