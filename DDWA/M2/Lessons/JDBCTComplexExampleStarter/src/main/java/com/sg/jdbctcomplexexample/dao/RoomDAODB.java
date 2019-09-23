/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.jdbctcomplexexample.dao;

import com.sg.jdbctcomplexexample.entity.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author seanking
 */
@Repository
public class RoomDAODB implements RoomDao{
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Room> getAllRooms() {
        //declaring query as a string
        final String SELECT_ALL_ROOMS = "SELECT * FROM room";
        // return results with query string and RoomMapper as parameters
        return jdbc.query(SELECT_ALL_ROOMS, new RoomMapper());
    }

    @Override
    public Room getRoomById(int id) {
        //surrounding query with a try-catch because 'queryForObject' will throw exception if no object returned
        try{
            //query string and call for 'queryForObject' with the additional parameter of the ID
            final String SELECT_ROOM_BY_ID = "SELECT * FROM room WHERE id = ?";
            return jdbc.queryForObject(SELECT_ROOM_BY_ID, new RoomMapper(), id);
        } catch(DataAccessException ex){
            //return null that we have an indicator the we could not retrieve the object
            return null;
        }
    }

    @Override
    //@Trasnactional means every query in this method in this method is part of one transaction
    //all or nothing
    @Transactional
    public Room addRoom(Room room) {
            final String INSERT_ROOM = "INSERT INTO room(name, description) VALUES(?,?)";
            //use update
            jdbc.update(INSERT_ROOM,
                    room.getName(),
                    room.getDescription());
            //after runnning query, we need to run a special query to get the ID from the database
            int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
            // now pud ID into the Room object and return it back
            room.setId(newId);
            return room;
    }

    @Override
    public void updateRoom(Room room) {
        final String UPDATE_ROOM = "UPDATE room SET name = ?, description = ? WHERE id = ?";
        jdbc.update(UPDATE_ROOM,
                room.getName(),
                room.getDescription(),
                room.getId());
    }

    @Override
    // we use transactional because we are making multiple modifications to the database in one method
    @Transactional
    public void deleteRoomById(int id) {
        // we have to do multiple layered delete because of the foreign key relationships
        // first delete bridge table for employee meeting by room, then meeting, then room
        final String DELETE_MEETING_EMPLOYEE_BY_ROOM = "DELETE me.* FROM meeting_employee me "
                + "JOIN meeting m ON me.meetingId = m.id WHERE m.roomId = ?";
        jdbc.update(DELETE_MEETING_EMPLOYEE_BY_ROOM, id);
        
        final String DELETE_MEETING_BY_ROOM = "DELETE FROM meeting WHERE roomId = ?";
        jdbc.update(DELETE_MEETING_BY_ROOM, id);
        
        final String DELETE_ROOM = "DELETE FROM room WHERE id = ?";
        jdbc.update(DELETE_ROOM, id);
    }
    
    public static final class RoomMapper implements RowMapper<Room>{
      @Override
      //this is public so we can add room object to room object
      public Room mapRow(ResultSet rs, int index) throws SQLException{
          Room rm = new Room();
          rm.setId(rs.getInt("id"));
          rm.setName(rs.getString("name"));
          rm.setDescription(rs.getString("description"));
          return rm;
      }
    }
    
}
