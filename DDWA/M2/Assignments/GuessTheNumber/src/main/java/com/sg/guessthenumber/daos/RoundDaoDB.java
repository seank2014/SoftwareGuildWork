/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.guessthenumber.daos;


import com.sg.guessthenumber.dto.Game;
import com.sg.guessthenumber.dto.Round;
import com.sg.guessthenumber.daos.GameDaoDB.GameMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author seanking
 */
@Repository
public class RoundDaoDB implements RoundDao {
    
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public RoundDaoDB(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Round addNewRound(Round round) {
        final String sql = "INSERT INTO rounds(gameId, userGuess, guessTime, result) VALUES (?,?,?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        
        jdbcTemplate.update((Connection conn) -> {
            
            PreparedStatement statement = conn.prepareStatement(
            sql,
            Statement.RETURN_GENERATED_KEYS);
            
            statement.setInt(1, round.getGameId());
            statement.setString(2, round.getUserGuess());
            statement.setTimestamp(3, Timestamp.valueOf(round.getTime()));
            statement.setString(4, round.getResult());
              return statement;
        }, keyHolder);
          
        round.setId(keyHolder.getKey().intValue());
        return round;
    }

    @Override
    public Round getRoundById(int id) {
       final String sql = "SELECT roundId, gameId, userGuess, guessTime, result FROM rounds WHERE roundId = ?;";

        try{
            Round round = jdbcTemplate.queryForObject(sql, new RoundMapper(), id);
            round.setGame(getGameForRound(id));
            return round;
        } catch (DataAccessException ex){
           return null; 
        }
         
    }
    
      private void associateAllVaries(List<Round> rounds) {
        for (Round round : rounds) {
round.setGame(getGameForRound(round.getId()));
        }
        
    }
    
     private Game getGameForRound(int roundId) {
        final String getGameForRound = "SELECT * FROM game JOIN rounds ON game.gameId = rounds.gameId "
            + "WHERE rounds.roundId = ?";
        return jdbcTemplate.queryForObject(getGameForRound, new GameMapper(), roundId);

    }
    
    @Override
    public List<Round> getAllRounds(int gameId) {
        final String sql = "SELECT roundId, gameId, userGuess, guessTime, result FROM rounds WHERE gameId = ?;";
        List <Round> rounds = jdbcTemplate.query(sql, new RoundMapper(), gameId);
        associateAllVaries(rounds);
        return rounds;
    }
    
    

    @Override
    public void updateRound(Round round) {
        final String sql = "UPDATE rounds SET "
                + "gameId = ?, "
                + "userGuess = ?, "
                + "guessTime = ?, "
                + "result = ? "
                + "WHERE roundId = ?;";
        
         jdbcTemplate.update(sql,
                round.getGameId(),
                round.getUserGuess(),
                round.getTime(),
                round.getResult());
    }

    @Override
    public void deleteRoundById(int id) {
        final String sql = "DELETE FROM rounds WHERE roundId = ?;";
        jdbcTemplate.update(sql, id);
    }
    
    private static final class RoundMapper implements RowMapper<Round>{

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();
            round.setId(rs.getInt("roundId"));
            round.setGameId(rs.getInt("gameId"));
            round.setUserGuess(rs.getString("userGuess"));
            round.setTime(rs.getTimestamp("guessTime").toLocalDateTime());
            round.setResult(rs.getString("result"));
            
            return round;
        }
        
    }
    
}
