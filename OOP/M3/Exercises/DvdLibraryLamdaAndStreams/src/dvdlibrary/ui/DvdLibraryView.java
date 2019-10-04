/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.ui;

import dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
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
        io.print("6. List DVDs in library within a certain number of years");
        io.print("7. List DVDs in library by rating");
        io.print("8. List DVDs in library by director, grouped by ratings");
        io.print("9. List DVDs in library by studio");
        io.print("10.List average age of DVDs in library");
        io.print("11. List newest DVD in library");
        io.print("12. List oldest DVD in library");
        io.print("13. List average amount of notes in Library");
        io.print("14. Exit");

        return io.readInt("Please select from the above choices.", 1, 14);
    }

    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter movie title");
        String director = io.readString("Please enter movie's director");
        LocalDate releaseDate = io.readLocalDate("Please enter release date in yyyy-mm-dd format");
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
                    + currentDvd.getReleaseDate().format(DateTimeFormatter.ofPattern("MM/dd/YYYY")) + ", "
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

        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate().format(DateTimeFormatter.ofPattern("MM/dd/YYYY")) + ": " + dvd.getDirector() + ", " + dvd.getMpaaRating() + ", " + dvd.getStudio() + ", " + " ' " + dvd.getUserComments() + " ' ");
            io.print("");
        } else {
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

    public void notFound() {
        io.print("Entry not found");
    }

    public void displayWithInrangeBanner() {
        io.print("===  Movies within x amount of years ===");
    }

    public int getNumberInYears() {
        int answer = io.readInt("Enter the last number of years from movies you would like to see");
        return answer;
    }

    public void displayMovieByRatingBanner() {
        io.print("=== Get movies by rating ===");
    }

    public String getRating() {
        return io.readString("Enter the rating you would like to get a listing for");
    }

    public void displayMovieByDirectorBanner() {
        io.print("=== Get movies by director ===");
    }

    public String getDirector() {
        return io.readString("\n Please note list will be sorted by ratings. Enter the director whose movies you'd like to see");
    }

    public void displayMovieByStudioBanner() {
        io.print("=== Get movies by studio ===");
    }

    public String getStudio() {
        return io.readString("Enter studio");
    }

    public void displayAverageAgeBanner() {
        io.print("=== List average age ===");
    }

    public void displayAvgAge(double number) {
        io.print(number);
    }

    public void displayNewestAgeBanner() {
        io.print("=== Newest Dvd ===");
    }

    public void displayOldestAgeBanner() {
        io.print("=== Oldest Dvd ===");
    }

      public void displayAverageNotesBanner() {
        io.print("=== Average amount of notes ===");
    }
      
    public void displayReturnToMenuBanner() {
        io.readString("Please hit enter to continue.");
    }

}
