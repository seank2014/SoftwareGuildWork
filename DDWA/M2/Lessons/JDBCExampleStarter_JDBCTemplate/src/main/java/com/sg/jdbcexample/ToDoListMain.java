/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.jdbcexample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author kylerudy
 */
@SpringBootApplication
public class ToDoListMain implements CommandLineRunner {
//was in previous JDBC
    @Autowired
    private JdbcTemplate jdbc;

    private static Scanner sc;

    public static void main(String[] args) {
        
        //wasn't in JDBC
        SpringApplication.run(ToDoListMain.class, args);
    }

    public void run(String... args) throws Exception {
        sc = new Scanner(System.in);

        do {
            System.out.println("To-Do List");
            System.out.println("1. Display List");
            System.out.println("2. Add Item");
            System.out.println("3. Update Item");
            System.out.println("4. Remove Item");
            System.out.println("5. Exit");

            System.out.println("Enter an option:");
            String option = sc.nextLine();
            try {
                switch (option) {
                    case "1":
                        displayList();
                        break;
                    case "2":
                        addItem();
                        break;
                    case "3":
                        updateItem();
                        break;
                    case "4":
                        //    removeItem();
                        break;
                    case "5":
                        System.out.println("Exiting");
                        System.exit(0);
                }
            } catch (SQLException ex) {
                System.out.println("Error communicating with database");
                System.out.println(ex.getMessage());
                System.exit(0);
            }

        } while (true);

    }

    /*
        
    /*read all*/ private void displayList() throws SQLException {
        List<ToDo> todos = jdbc.query("SELECT * FROM todo", new ToDoMapper());
        for (ToDo td : todos) {
            System.out.printf("%s: %s -- %s -- %s\n",
                    td.getId(),
                    td.getTodo(),
                    td.getNote(),
                    td.isFinished());
        }
        System.out.println("");
    }

    /*create*/ private void addItem() throws SQLException { // can no longer have static for some reason
        System.out.println("Add Item");
        System.out.println("What is the task?");
        String task = sc.nextLine();
        System.out.println("Any additional notes?");
        String note = sc.nextLine();

        /* no longer needs this whole method with template*/
 /*
     try (Connection conn = ds.getConnection()) {
           String sql = "INSERT INTO todo(todo, note) VALUES (?,?)";
          PreparedStatement pStmt = conn.prepareCall(sql);
           pStmt.setString(1, task);
            
            pStmt.setString(2, note);
            pStmt.executeUpdate();*/
        jdbc.update("INSERT INTO todo(todo, note) VALUES (?,?), task, note");
        System.out.println("Add Complete");

    }

    /*update*/ private void updateItem() throws SQLException {
        System.out.println("Update Item");
        System.out.println("Which item do you want to update?"); // retrieving current todo object by number
        String itemId = sc.nextLine();

        //dont need this with jdbc template
        /*
        try (Connection conn = ds.getConnection()) { // connect to database for object
            String sql = "SELECT * FROM todo WHERE id = ?"; // "?" represents user input
            //make a prepared statement to get ToDo item based off ID user inputted
            PreparedStatement pStmt = conn.prepareCall(sql);
            pStmt.setString(1, itemId);
            ResultSet rs = pStmt.executeQuery();
            rs.next();
            //we use result set we get back to build  ToDo object
            //getting the  necessary fields for the object out of the result set
            ToDo td = new ToDo();
            td.setId(rs.getInt("id"));
            td.setTodo(rs.getString("todo"));
            td.setNote(rs.getString("note"));
            td.setFinished(rs.getBoolean("finished"));
         */
        ToDo item = jdbc.queryForObject("SELECT * FROM todo WHERE id = ?", new ToDoMapper(),
                itemId);

        //display current fields in object retrieved
        System.out.println("1. ToDo - " + item.getTodo());
        System.out.println("2. Note - " + item.getNote());
        System.out.println("3. Finished - " + item.isFinished());

        //then ask user to choose number for what they want to change
        System.out.println("What would you like to change?");
        String choice = sc.nextLine();
        switch (choice) {
            case "1":
                System.out.println("Enter new ToDo");
                String todo = sc.nextLine();
                item.setTodo(todo);
                break;
            case "2":
                System.out.println("Enter new Note:");
                String note = sc.nextLine();
                item.setNote(note);
                break;
            case "3":
                System.out.println("Toggling Finished to " + !item.isFinished());
                item.setFinished(!item.isFinished());
                break;
            default:
                System.out.println("No change made");
                return;
        }

        /*String updateSql = "UPDATE todo SET todo = ?, note = ?, finished = ? WHERE id = ?";

            //use existing connection to make prepared statement to do our update
            PreparedStatement updatePStmt = conn.prepareCall(updateSql);
            //set updated values to prepared statement
            updatePStmt.setString(1, td.getTodo());
            updatePStmt.setString(2, td.getNote());
            updatePStmt.setBoolean(3, td.isFinished());
            updatePStmt.setInt(4, td.getId());
            //user executeUpdate to push changes through
            updatePStmt.executeUpdate();*/
        jdbc.update("UPDATE todo SET todo = ?, note = ?, finished = ? WHERE id = ?",
                item.getTodo(),
                item.getNote(),
                item.isFinished(),
                item.getId()
        );
        System.out.println("Update Complete");
    }

private void removeItem() /*delete*/ throws SQLException {
 System.out.println("Remove Item");
//request user to put itemId
System.out.println("Which item would you like to remove?");
String itemId = sc.nextLine();

/* dont need this long piece
        //try (Connection conn = ds.getConnection()) {
        //    String sql = "DELETE FROM todo WHERE id = ?";
        //    PreparedStatement pStmt = conn.prepareCall(sql);
        //    pStmt.setString(1, itemId);
          //  pStmt.executeUpdate();
          
          */
        jdbc.update("DELETE FROM todo WHERE id = ?", itemId);
           System.out.println("Remove Complete");
            //Once item is deleted, the rest of item will move to stay consecutive numbers
       }
   
    
   
/* dont need this method with template
    private static DataSource getDataSource() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        instantiating MysqlDataSource object 
       to set up a connection*/
       /* ds.setServerName("localhost");//setting server name to 'localhost'.we are connecting to our local database
        ds.setDatabaseName("todoDB"); //database name, which we created in sql script earlier
        ds.setUser("root");
        ds.setPassword("Cakeme2014");
        ds.setServerTimezone("America/Chicago");// ime zone helps the server handle times and dates correctly
        ds.setUseSSL(false); // would usually set this to true but would be overkill for this exercise
        ds.setAllowPublicKeyRetrieval(true); // allows our JDBC driver to send password to our database securely

        return ds;
    }

connect to database using files with JDBC template*/

    
  
   
    private static final class ToDoMapper implements RowMapper<ToDo> {

    @Override
    public ToDo mapRow(ResultSet rs, int index) throws SQLException {
        ToDo td = new ToDo();
        td.setId(rs.getInt("id"));
        td.setTodo(rs.getString("todo"));
        td.setNote(rs.getString("note"));
        td.setFinished(rs.getBoolean("finished"));
        return td;
    }
}

}
