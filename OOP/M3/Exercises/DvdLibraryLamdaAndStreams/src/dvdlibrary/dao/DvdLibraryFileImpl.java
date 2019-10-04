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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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

    @Override
    public List<Dvd> movieInLastYears(int ageInYears) throws DvdLibraryDaoException {
        loadLibrary();        
        return dvds.values()
                .stream()
                .filter(s -> s.getAgeInYears() < ageInYears)
                .collect(Collectors.toList());        
    }
    
    @Override
    public List<Dvd> getMovieByRating(String mpaaRating) throws DvdLibraryDaoException {
        loadLibrary();
        return dvds.values()
                .stream()
                .filter(s -> s.getMpaaRating().equalsIgnoreCase(mpaaRating))
                .collect(Collectors.toList());
    }
    
    @Override
    public Map<String, List<Dvd>> getMovieByDirectorGroupByRating(String director) throws DvdLibraryDaoException {
        loadLibrary();
        return dvds.values()
                .stream()
                .filter(s -> s.getDirector().equalsIgnoreCase(director))
                .collect(Collectors.groupingBy(Dvd::getMpaaRating));
    }
    
    @Override
    public List<Dvd> movieByStudio(String studio) throws DvdLibraryDaoException {
        loadLibrary();
        return dvds.values()
                .stream()
                .filter(s -> s.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
    }
    
    @Override
    public double getAverageAge() throws DvdLibraryDaoException {
        loadLibrary();
        return dvds.values()
                .stream()
                .mapToLong(Dvd::getAgeInYears)
                .average()
                .getAsDouble();
        
    }
    
    @Override
    public List<Dvd> getNewestMovie() throws DvdLibraryDaoException {
        loadLibrary();
        return dvds.values()
                .stream()
                .sorted(Comparator.comparingLong(Dvd :: getAgeInDays))    
                .collect(Collectors.toList());          
    }
    
    @Override
    public List<Dvd> getOldestMovie() throws DvdLibraryDaoException {
        loadLibrary();
        return dvds.values()
                .stream()
                .sorted(Comparator.comparingLong(Dvd :: getAgeInDays).reversed())
                .collect(Collectors.toList());
                
    }
    
    @Override
    public double findAverageNumberOfNote() throws DvdLibraryDaoException {
        double count = 0;
        loadLibrary();
        
        for(Dvd dvds: dvds.values()){
            if(!dvds.getUserComments().equals(" ")){
                count++;
            }   
        }
        
      double allDvds = getAllDvds().size();
        
        return count/allDvds;
        
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
            currentDvd.setDirector(currentTokens[1]);
            currentDvd.setReleaseDate(LocalDate.parse(currentTokens[2]));
            currentDvd.setMpaaRating(currentTokens[3]);
            currentDvd.setStudio(currentTokens[4]);
            currentDvd.setUserComments(currentTokens[5]);
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();
    }
    
    private void writeLibrary() throws DvdLibraryDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException("Could not save dvd data.", e);
        }
        
        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
            out.println(currentDvd.getTitle() + DELIMITER
                    + currentDvd.getDirector() + DELIMITER
                    + currentDvd.getReleaseDate().format(DateTimeFormatter.ISO_DATE) + DELIMITER
                    + currentDvd.getMpaaRating() + DELIMITER
                    + currentDvd.getStudio() + DELIMITER
                    + currentDvd.getUserComments());
            out.flush();
        }
        out.close();
    }
    
}
