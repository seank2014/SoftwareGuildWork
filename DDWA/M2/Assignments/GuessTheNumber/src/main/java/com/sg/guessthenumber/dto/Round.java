/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessthenumber.dto;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author seanking
 */
public class Round {
    int id;
    int gameId;
    String userGuess;
    LocalDateTime time;
    String result;
    Game game;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getUserGuess() {
        return userGuess;
    }

    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id;
        hash = 61 * hash + this.gameId;
        hash = 61 * hash + Objects.hashCode(this.userGuess);
        hash = 61 * hash + Objects.hashCode(this.time);
        hash = 61 * hash + Objects.hashCode(this.result);
        hash = 61 * hash + Objects.hashCode(this.game);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Round other = (Round) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.gameId != other.gameId) {
            return false;
        }
        if (!Objects.equals(this.userGuess, other.userGuess)) {
            return false;
        }
        if (!Objects.equals(this.result, other.result)) {
            return false;
        }
        if (!Objects.equals(this.time, other.time)) {
            return false;
        }
        if (!Objects.equals(this.game, other.game)) {
            return false;
        }
        return true;
    }   
}
