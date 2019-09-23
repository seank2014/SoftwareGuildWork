/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessthenumber.controller;


import com.sg.guessthenumber.dto.Game;
import com.sg.guessthenumber.dto.Round;
import com.sg.guessthenumber.services.ServiceLayer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author seanking
 */
@RestController
@RequestMapping("/")
public class RESTNumberController {
  
    @Autowired
 private final ServiceLayer service;
 
 public RESTNumberController (ServiceLayer service){
     this.service = service;
 }
 
  //begin - POST 201  - need to generate an answer - must generated
 @PostMapping("/begin")
 @ResponseStatus(HttpStatus.CREATED)
 public Game createGame(@RequestBody Game game){
     return service.createGame(game);
 }
 
 //guess - POST pass guess and gameId in JSON calculate the results and mark game as finished return round object
 @PostMapping("/guess")
 public Round checkGuess(@RequestBody Round round) throws Exception {
   Round r = service.createGuess(round.getUserGuess(), round.getGameId());
   if(!r.getGame().isSolved()){
       r.getGame().setAnswer("Not solved yet.");
   } else{
       r.getGame().getAnswer();
   }
    return r;
 }
 
 //game - GET
 @GetMapping("/game")
 public List<Game> all(){
   List <Game> games = service.getAllGames();
   for(Game game : games){
       if(!game.isSolved()){
          game.setAnswer("Not solved yet.");
       } else {
         game.getAnswer();
     }
   }
   return games;
 }
 
 //game/gameId  - GET
 @GetMapping("/game/{gameId}")
 public ResponseEntity<Game> getGameById(@PathVariable int gameId){
     Game game = service.getGameById(gameId);
     if (game == null){
         return new ResponseEntity(null, HttpStatus.NOT_FOUND);
     }
     if(!game.isSolved()){
          game.setAnswer("Not solved yet.");
       } else {
         game.getAnswer();
     }
     return ResponseEntity.ok(game);
 }
 
 
 //rounds/gameId - GET
 @GetMapping("/rounds/{gameId}")
public List<Round> getRoundByGameId(@PathVariable int gameId){
    List <Round> rounds = service.getAllRounds(gameId);
    for(Round round : rounds){
       if(!round.getGame().isSolved()){
          round.getGame().setAnswer("Not solved yet.");
       } 
    } 
        return rounds;

} 
}
 
 

