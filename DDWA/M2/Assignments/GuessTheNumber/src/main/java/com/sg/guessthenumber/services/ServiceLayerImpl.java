/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessthenumber.services;

import com.sg.guessthenumber.daos.GameDao;
import com.sg.guessthenumber.daos.RoundDao;
import com.sg.guessthenumber.dto.Game;
import com.sg.guessthenumber.dto.Round;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayerImpl implements ServiceLayer {

    Game game;

    Round round;

    @Autowired
    GameDao gameDB;

    @Autowired
    RoundDao roundDB;

    public ServiceLayerImpl(GameDao gameDB, RoundDao roundDB) {
        this.gameDB = gameDB;
        this.roundDB = roundDB;
    }

    @Override
    public Game createGame(Game game) {
        return gameDB.createGame(game);
    }

    @Override
    public Game getGameById(int id) {
        return gameDB.getGameById(id);
    }

    @Override
    public List<Game> getAllGames() {
        List<Game> allGames=gameDB.getAllGames();
        for(Game game : allGames){
            if(game.isSolved()==true){
                game.getAnswer();
            }
            }
                return allGames;

        }
        
             
    

    @Override
    public Round addNewRound(Round round) {
        return roundDB.addNewRound(round);
    }

    @Override
    public Round getRoundById(int id) {

        return roundDB.getRoundById(id);
    }

    @Override
    public List<Round> getAllRounds(int gameId) {
        List<Round> rounds = roundDB.getAllRounds(gameId);
        for(Round round : rounds){
            if(round.getResult().equals("e:4:p:0")){
                round.getGame().setSolved(true);
            }
        }
        return rounds;
    }

    @Override
    public Round createGuess(String userGuess, int gameId) throws Exception {
        Game newGame = getGameById(gameId);
        List<Round> rounds = roundDB.getAllRounds(gameId);

        if (newGame == null) {
            throw new GameNotFoundException("Game not found");
        } 

        
        Round r = new Round();
        if (newGame.isSolved()==false  && rounds.size() < 10) {
            r.setGame(newGame);
            r.setGameId(gameId);
            r.setTime(LocalDateTime.now());
            r.setUserGuess(userGuess);
            r.setResult(checkResult(newGame.getAnswer(),userGuess, gameId));
            if(r.getResult().equals("e:4:p:0")){
                r.getGame().setSolved(true);
            }
            roundDB.addNewRound(r);
            gameDB.updateGame(newGame);
        } else {
            throw new GameOverException("Game is over");

        }

        return r;

    }
    
     private Game getGameForRound(Round round){
         int gameId = round.getGameId();
        Game game = gameDB.getGameById(gameId);
       round.setGame(game);
        return game;
      
    }

    
    @Override
    public String checkResult(String answer, String userGuess, int gameId) {
        int e = 0;
        int p = 0;
        
        Game game = gameDB.getGameById(gameId);
        game.setAnswer(answer);
        
        Round round = new Round();
        round.setGame(game);
        round.setUserGuess(userGuess);
        
        

        char[] a = game.getAnswer().toCharArray();
        char[] g = round.getUserGuess().toCharArray();

        if (a[0] == g[0]) {
            e++;
        } else if (a[0] == g[1] || a[0] == g[2] || a[0] == g[3]) {
            p++;
        }

        if (a[1] == g[1]) {
            e++;
        } else if (a[1] == g[0] || a[1] == g[2] || a[0] == g[3]) {
            p++;
        }

        if (a[2] == g[2]) {
            e++;
        } else if (a[2] == g[0] || a[2] == g[1] || a[2] == g[3]) {
            p++;
        }
        if (a[3] == g[3]) {
            e++;
        } else if (a[3] == g[1] || a[3] == g[2] || a[3] == g[0]) {
            p++;
        }

        if (e == 4) {
            round.getGame().setSolved(true);
//            game.setSolved(true);

        } else {
            round.getGame().setSolved(false);
//            game.setSolved(false);
        }
        

       return "e:" + e + ":p:" + p;
    }
}
