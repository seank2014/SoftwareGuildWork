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

/**
 *
 * @author seanking
 */
public class DvdLibraryController {

    DvdLibraryView view;
    DvdLibraryDao dao;
    private Dvd updatedvd;

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
        Dvd editedDvd = dao.getDvd(title);
        if (editedDvd != null) {
            Dvd dvdTwo = view.getNewDvdInfo();
            if (title != dvdTwo.getTitle()) {
                dao.removeDvd(title);
                title = dvdTwo.getTitle();
                dao.addDvd(title, dvdTwo);
            } else {
                Dvd dvdOne = dao.editDvd(title, dvdTwo);
            }
            view.displayEditComplete();
        } else {
            System.out.println("Entry not found");
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
