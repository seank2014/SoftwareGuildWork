/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.ui;

import dvdlibrary.dto.Dvd;
import java.util.List;

/**
 
 * @author seanking
 */
public class DvdLibraryView {

    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("1. Add DVD to library");
        io.print("2. Remove DVD to library");
        io.print("3. Edit DVD library");
        io.print("4. List DVDs in library");
        io.print("5. View DVD");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter movie title");
       String director = io.readString("Please enter movie's director");
        String releaseDate = io.readString("Please enter release date");
        String mpaaRating = io.readString("Please enter MPAA rating");
        String studio = io.readString("Enter movie studio");
        String userComments = io.readString("Enter any additional notes about the movie");
        Dvd currentDvd = new Dvd(title);
        currentDvd.setDirector(director);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setStudio(studio);
        currentDvd.setUserComments(userComments);
        return currentDvd;
    }

    public void displayCreateDvdBanner() {
        io.print("=== Create DVD ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString("DVD successfully created. Please hit enter to continue");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            io.print(currentDvd.getTitle() + " : "
                    + currentDvd.getDirector() + ", "
                    + currentDvd.getReleaseDate() + ", "
                    + currentDvd.getMpaaRating() + ", "
                    + currentDvd.getStudio() + ", "
                    + " ' " + currentDvd.getUserComments() + " ' ");

        }
        io.readString("Please hit enter to continue");

    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Dvds ===");
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Display Dvd ===");
    }

    public String getTitleChoice() {
        return io.readString("Please enter the movie title.");
    }

    public void displayDvd(Dvd dvd) {
        
          if (dvd != null){ 
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate() + ": " + dvd.getDirector() + ", " + dvd.getMpaaRating() + ", " + dvd.getStudio() + ", " + " ' " + dvd.getUserComments() + " ' ");
            io.print("");
         } else{
                   io.print("Nothing was found in our records. Please try again.");

            }
        
                      io.readString("Please hit enter to continue.");

        }   
        

    public void displayRemoveDvdBanner() {
        io.print("=== Remove Dvd ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Dvd successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayEditBanner() {
        io.print("=== Edit info ===");
    }

    public void displayEditComplete() {
        io.print("Edit complete");
    }
    
    public void notFound(){
        io.print("Entry not found");
    }

}
