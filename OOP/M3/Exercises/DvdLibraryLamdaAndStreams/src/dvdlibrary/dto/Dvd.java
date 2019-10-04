/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dto;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author seanking
 */
public class Dvd {

    private String title;
    private String director;
    private LocalDate releaseDate;
    private String mpaaRating;
    private String studio;
    private String userComments;

    public Dvd(String title) {
        this.title = title;
    }
    
     public String getTitle() {
        return title;
    }
     
     public String getDirector(){
        return director;
    }
    
    public void setDirector(String director){
        this.director = director;
    }


    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserComments() {
        return userComments;
    }

    public void setUserComments(String userComments) {
        this.userComments = userComments;
    }
    
    public long getAgeInYears(){
        Period p = releaseDate.until(LocalDate.now());
        return p.getYears();
        
    }
    
    public long getAgeInDays(){
   long newLong = releaseDate.until(LocalDate.now(), ChronoUnit.DAYS);
        return newLong;
    }

}
