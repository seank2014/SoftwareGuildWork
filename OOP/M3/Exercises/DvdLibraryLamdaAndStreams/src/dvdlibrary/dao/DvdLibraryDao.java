/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author seanking
 */
public interface DvdLibraryDao {

    Dvd addDvd(String title, Dvd dvd)
            throws DvdLibraryDaoException;

    List<Dvd> getAllDvds()
            throws DvdLibraryDaoException;

    Dvd getDvd(String title)
            throws DvdLibraryDaoException;

    Dvd removeDvd(String title)
            throws DvdLibraryDaoException;

    Dvd editDvd(String title, Dvd editedDvd)
            throws DvdLibraryDaoException;
    
    List <Dvd> movieInLastYears(int ageInYears)
            throws DvdLibraryDaoException;
    
    List <Dvd> getMovieByRating(String mpaaRating)
            throws DvdLibraryDaoException;
    
    Map<String, List <Dvd>> getMovieByDirectorGroupByRating(String director)
            throws DvdLibraryDaoException;
    
    List<Dvd> movieByStudio(String studio)
            throws DvdLibraryDaoException;
    
    double getAverageAge()
            throws DvdLibraryDaoException;
    
    List <Dvd> getNewestMovie()
            throws DvdLibraryDaoException;
    
    List <Dvd> getOldestMovie()
            throws DvdLibraryDaoException;
    
    double findAverageNumberOfNote()
            throws DvdLibraryDaoException;

    
}
