/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.controller;

import dvdlibrary.dao.DvdLibraryDao;
import dvdlibrary.dao.DvdLibraryDaoException;
import dvdlibrary.dto.Dvd;
import dvdlibrary.ui.DvdLibraryView;
import java.util.List;
import java.util.Map;

/**
 *
 * @author seanking
 */
public class DvdLibraryController {

    DvdLibraryView view;
    DvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        createDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        editDvd();
                        break;
                    case 4:
                        listDvds();
                        break;
                    case 5:
                        viewDvd();
                        break;
                    case 6:
                        getMoviesWithinRange();
                        break;
                    case 7:
                        getRating();
                        break;
                    case 8:
                         getDirectorGroupByRating();
                         break;
                    case 9:
                        listByStudio();
                        break;
                    case 10:
                         averageAge();
                         break;
                    case 11:
                        newestAge();
                        break;
                    case 12:
                        oldestAge();
                        break;
                    case 13:
                       averageNotes();
                       break;
                    case 14:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();

        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();

    }

    private void createDvd() throws DvdLibraryDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }

    private void listDvds() throws DvdLibraryDaoException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void viewDvd() throws DvdLibraryDaoException {
        view.displayDisplayDvdBanner();
        String title = view.getTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdLibraryDaoException {
        view.displayDisplayDvdBanner();
        String title = view.getTitleChoice();
        dao.removeDvd(title);
        view.displayRemoveSuccessBanner();
    }

    private void editDvd() throws DvdLibraryDaoException {
        view.displayEditBanner();
        String title = view.getTitleChoice();
       dao.getDvd(title);
        if (dao.getDvd(title) != null) {
            Dvd editedDVD = view.getNewDvdInfo();
            dao.editDvd(title, editedDVD);           
            view.displayEditComplete();
        } else {
            view.notFound();
        }
    }
    
    private void getMoviesWithinRange() throws DvdLibraryDaoException{
        view.displayWithInrangeBanner();
        int userInput = view.getNumberInYears();
       List<Dvd> dvdList = dao.movieInLastYears(userInput); 
        view.displayDvdList(dvdList);
    }
    
    private void getRating() throws DvdLibraryDaoException{
        view.displayMovieByRatingBanner();
        String userInput = view.getRating();
        List<Dvd> dvdList = dao.getMovieByRating(userInput);
        view.displayDvdList(dvdList);
    }
    
    private void getDirectorGroupByRating() throws DvdLibraryDaoException{
        view.displayMovieByDirectorBanner();
        String userInput = view.getDirector();
      Map<String, List<Dvd>> newMap = dao.getMovieByDirectorGroupByRating(userInput);
            
      for( List <Dvd> dvds : newMap.values()){
                view.displayDvdList(dvds);
      }
      
view.displayReturnToMenuBanner();  

}
    
    private void listByStudio() throws DvdLibraryDaoException{
        view.displayMovieByStudioBanner();
        String userInput = view.getStudio();
        List <Dvd> dvds = dao.movieByStudio(userInput);
        view.displayDvdList(dvds);
    }
    
    private void averageAge() throws DvdLibraryDaoException{
        view.displayAverageAgeBanner();
        view.displayAvgAge(dao.getAverageAge());
        view.displayReturnToMenuBanner();
    }
    
    private void newestAge() throws DvdLibraryDaoException{
        view.displayNewestAgeBanner();
        List <Dvd> newList = dao.getNewestMovie();
        Dvd newDvd = newList.get(0);
        view.displayDvd(newDvd);
    }
    
    private void oldestAge() throws DvdLibraryDaoException {
        view.displayOldestAgeBanner();
        List <Dvd> oldList =  dao.getOldestMovie();
        Dvd oldDvd = oldList.get(0);
        view.displayDvd(oldDvd);
    }
    
    private void averageNotes() throws DvdLibraryDaoException{
        view.displayAverageNotesBanner();
        double average = dao.findAverageNumberOfNote();
        view.displayAvgAge(average);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
