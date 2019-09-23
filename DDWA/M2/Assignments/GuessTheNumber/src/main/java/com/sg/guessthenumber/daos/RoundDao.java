/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessthenumber.daos;

import com.sg.guessthenumber.dto.Round;
import java.util.List;

/**
 *
 * @author seanking
 */
public interface RoundDao {
    //Create
    Round addNewRound(Round round);
    //Read
    Round getRoundById(int id);
    //Readall
    List<Round>getAllRounds(int gameId);
    //Update
    void updateRound(Round round);
    
    //Delete
    void deleteRoundById(int id);
}
