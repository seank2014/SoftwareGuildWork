/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.Dvd;
import java.util.List;

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
}
