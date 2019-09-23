/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessthenumber.daos;

import com.sg.guessthenumber.dto.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author seanking
 */
@Repository
public class GameDaoDB implements GameDao {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public GameDaoDB(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    @Transactional
    public Game createGame(Game game) {
        
        final String sql = "INSERT INTO game(answer) VALUES (?);";
        GeneratedKeyHolder keyHolder  = new GeneratedKeyHolder();
        
        jdbcTemplate.update((Connection conn) -> {
        
        PreparedStatement statement = conn.prepareStatement(
        sql,
         Statement.RETURN_GENERATED_KEYS);
        
        statement.setString(1, game.getAnswer());
        return statement;
        }, keyHolder);
        
        game.setId(keyHolder.getKey().intValue());
        
        return game; 
    }


    @Override
     @Transactional
    public Game getGameById(int id) {
        
        final String sql = "SELECT gameId, answer, solved FROM game WHERE gameId = ?;";
        
        return jdbcTemplate.queryForObject(sql, new GameMapper(), id);
    }

    @Override
    @Transactional
    public List<Game> getAllGames() {
        final String sql = "SELECT * FROM game;";
        return jdbcTemplate.query(sql, new GameMapper());
    }

    @Override
    @Transactional
    public void updateGame(Game game) {
        final String sql = "UPDATE game SET "
                + "answer = ?, "
                + "solved = ? "
                + "WHERE gameId = ?;";
        
        jdbcTemplate.update(sql,
                game.getAnswer(),
                game.isSolved(),
                game.getId());
    }

    @Override
    @Transactional
    public void deleteGame(int id) {
        final String round = "DELETE FROM rounds WHERE gameId = ?;";
        
        jdbcTemplate.update(round, id);
        
        final String sql = "DELETE FROM game WHERE gameId = ?;";
        jdbcTemplate.update(sql, id);
    }
    
    
    public static final class GameMapper implements RowMapper<Game>{

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game();
            game.setId(rs.getInt("gameId"));
            game.setAnswer(rs.getString("answer"));
            game.setSolved(rs.getBoolean("solved"));
            return game;
        }
        
    }
}
