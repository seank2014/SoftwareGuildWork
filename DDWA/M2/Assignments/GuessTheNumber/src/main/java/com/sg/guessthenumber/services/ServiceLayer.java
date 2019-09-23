/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessthenumber.services;

import com.sg.guessthenumber.dto.Game;
import com.sg.guessthenumber.dto.Round;
import java.util.List;

/**
 *
 * @author seanking
 */
public interface ServiceLayer {
    
    Game createGame(Game game);

    Game getGameById(int id);

    List<Game> getAllGames();

    Round addNewRound(Round round);

    Round getRoundById(int id);

    List<Round> getAllRounds(int gameId);
    
    String checkResult(String userGuess, String answer, int gameId);
    
   Round createGuess(String userGuess, int gameId)throws Exception;
   
}
