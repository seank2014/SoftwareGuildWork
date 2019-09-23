/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessthenumber.daos;

import com.sg.guessthenumber.dto.Game;
import java.util.List;

/**
 *
 * @author seanking
 */
public interface GameDao {
    
    //Create
    Game createGame (Game game);
    //Read
    Game getGameById(int id);
    
    //ReadAll
    List<Game> getAllGames();
    
    // Update
    void updateGame(Game game);//is game supposed to be updated each round?
    
    //Delete
    void deleteGame(int id);
    
}
