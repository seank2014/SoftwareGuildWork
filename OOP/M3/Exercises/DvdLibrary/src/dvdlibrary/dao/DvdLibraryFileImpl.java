/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 *
 * @author seanking
 */
public class DvdLibraryFileImpl implements DvdLibraryDao {

    private Map<String, Dvd> dvds = new HashMap<>();
    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";

    @Override
    public Dvd addDvd(String title, Dvd dvd) throws DvdLibraryDaoException {
        Dvd newDvd = dvds.put(title, dvd);
        writeLibrary();
        return newDvd;
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryDaoException {
        loadLibrary();
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) throws DvdLibraryDaoException {
        loadLibrary();
        return dvds.get(title);
    }

    @Override
    public Dvd removeDvd(String tile) throws DvdLibraryDaoException {
        Dvd removedDvd = dvds.remove(tile);
        writeLibrary();
        return removedDvd;
    }

    @Override
    public Dvd editDvd(String title, Dvd editedDvd) throws DvdLibraryDaoException {
        
       
        dvds.put(title, editedDvd);
        writeLibrary();
        return editedDvd;
    }

    private void loadLibrary() throws DvdLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load library data into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Dvd currentDvd = new Dvd(currentTokens[0]);
            currentDvd.setReleaseDate(currentTokens[1]);
            currentDvd.setMpaaRating(currentTokens[2]);
            currentDvd.setStudio(currentTokens[3]);
            currentDvd.setUserComments(currentTokens[4]);

            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();
    }

    private void writeLibrary() throws DvdLibraryDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException(
                    "Could not save dvd data.", e);
        }

        List<Dvd> dvdList = this.getAllDvds();//cant use values cause then my program doesnt loan
        for (Dvd currentDvd : dvdList) {
            out.println(currentDvd.getTitle() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getMpaaRating() + DELIMITER
                    + currentDvd.getStudio() + DELIMITER
                    +currentDvd.getUserComments());
            out.flush();
        }
        out.close();
    }

}
