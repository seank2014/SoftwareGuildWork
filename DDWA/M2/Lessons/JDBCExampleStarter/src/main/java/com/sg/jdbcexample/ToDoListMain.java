/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.jdbcexample;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.sql.DataSource;

/**
 *
 * @author kylerudy
 */
public class ToDoListMain {

    private static Scanner sc;
    private static DataSource ds;

    public static void main(String[] args) {

        try {
            ds = getDataSource(); // uses Datasource method and catches SQL exceptions
        } catch (SQLException ex) {
            System.out.println("Error connecting to database");
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        // This try catch needed to be in the beggining of the method. 
        //When I put it at the end of the do while, the program would throw an error.

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
                        removeItem();
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

    /*read all*/ private static void displayList() throws SQLException {
        try (Connection conn = ds.getConnection()) {
            /*using try-with-resources to create connection*/
            Statement stmt = conn.createStatement();
            /*create statement with connection*/
            ResultSet rs = stmt.executeQuery("SELECT * FROM todo");
            /* use executeQuery to run our
            query*/

            while (rs.next()) {
                System.out.printf("%s: %s -- %s -- %s\n",
                        /*printf is used when you want to format your string. 
                         For a simple example ->
                        ("Hello, " + username + "! How are you?") = ("Hello, %s! How are you? */
                        rs.getString("id"),
                        rs.getString("todo"),
                        rs.getString("note"),
                        rs.getBoolean("finished"));
            }/*use loop to move through ResultSet*/
            System.out.println("");
        }

    }

    /*create*/ private static void addItem() throws SQLException {
        System.out.println("Add Item");
        System.out.println("What is the task?");
        String task = sc.nextLine();
        System.out.println("Any additional notes?");
        String note = sc.nextLine();

        try (Connection conn = ds.getConnection()) {
            /*try with resources to get Connection*/
            String sql = "INSERT INTO todo(todo, note) VALUES (?,?)";
            PreparedStatement pStmt = conn.prepareCall(sql);
            /*since we are using user input
            we will use prepared statement to avoid SQL injection attacks*/
            pStmt.setString(1, task);
            /*row start as Zero. 
            we don't call 0(id) because it automatic and 4(finshed) because we set it to false
            the other two columns are allowed to update*/
            pStmt.setString(2, note);
            pStmt.executeUpdate();
            System.out.println("Add Complete");

        }

    }

    private static void updateItem() /*update*/ throws SQLException {
        System.out.println("Update Item");
        System.out.println("Which item do you want to update?"); // retrieving current todo object by number
        String itemId = sc.nextLine();
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

            //display current fields in object retrieved
            System.out.println("1. ToDo - " + td.getTodo());
            System.out.println("2. Note - " + td.getNote());
            System.out.println("3. Finished - " + td.isFinished());

            //then ask user to choose number for what they want to change
            System.out.println("What would you like to change?");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter new ToDo");
                    String todo = sc.nextLine();
                    td.setTodo(todo);
                    break;
                case "2":
                    System.out.println("Enter new Note:");
                    String note = sc.nextLine();
                    td.setNote(note);
                    break;
                case "3":
                    System.out.println("Toggling Finished to " + !td.isFinished());
                    td.setFinished(!td.isFinished());
                    break;
                default:
                    System.out.println("No change made");
                    return;
            }
            String updateSql = "UPDATE todo SET todo = ?, note = ?, finished = ? WHERE id = ?";

            //use existing connection to make prepared statement to do our update
            PreparedStatement updatePStmt = conn.prepareCall(updateSql);
            //set updated values to prepared statement
            updatePStmt.setString(1, td.getTodo());
            updatePStmt.setString(2, td.getNote());
            updatePStmt.setBoolean(3, td.isFinished());
            updatePStmt.setInt(4, td.getId());
            //user executeUpdate to push changes through
            updatePStmt.executeUpdate();
            System.out.println("Update Complete");

        }

    }

    private static void removeItem() /*delete*/ throws SQLException {
        System.out.println("Remove Item");
        //request user to put itemId
        System.out.println("Which item would you like to remove?");
        String itemId = sc.nextLine();
        //Make connection to database and used prepared statement to remove item
        try (Connection conn = ds.getConnection()) {
            String sql = "DELETE FROM todo WHERE id = ?";
            PreparedStatement pStmt = conn.prepareCall(sql);
            pStmt.setString(1, itemId);
            pStmt.executeUpdate();
            System.out.println("Remove Complete");
            //Once item is deleted, the rest of item will move to stay consecutive numbers
        }
    }

    private static DataSource getDataSource() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        /* instantiating MysqlDataSource object 
       to set up a connection*/
        ds.setServerName("localhost");//setting server name to 'localhost'.we are connecting to our local database
        ds.setDatabaseName("todoDB"); //database name, which we created in sql script earlier
        ds.setUser("root");
        ds.setPassword("Cakeme2014");
        ds.setServerTimezone("America/Chicago");// ime zone helps the server handle times and dates correctly
        ds.setUseSSL(false); // would usually set this to true but would be overkill for this exercise
        ds.setAllowPublicKeyRetrieval(true); // allows our JDBC driver to send password to our database securely

        return ds;
    }

}
