/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary.dao;

import dvdlibrary.dto.Dvd;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author seanking
 */
public class DvdLibraryFileImplTest {

    DvdLibraryDao dao = new DvdLibraryFileImpl();

    public DvdLibraryFileImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws DvdLibraryDaoException {
        List<Dvd> dvds = dao.getAllDvds();
        for (Dvd dvd : dvds) {
            dao.removeDvd(dvd.getTitle());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addDvd method, of class DvdLibraryFileImpl.
     */
    @Test
    public void testAddGetDvd() throws Exception {
        //Arrange
        Dvd dvd1 = new Dvd("1dvd");
        dvd1.setReleaseDate(LocalDate.now());
        dvd1.setMpaaRating("arating");
        dvd1.setStudio("studio");
        dvd1.setUserComments("none");

        dao.addDvd(dvd1.getTitle(), dvd1);

        //Act
        Dvd fromDao = dao.getDvd(dvd1.getTitle());
        //Assert
        assertEquals(dvd1, fromDao);
    }

    /**
     * Test of getDvd method, of class DvdLibraryFileImpl.
     */
    @Test
    public void testGetAllDvds() throws Exception {
        //Arrange
        Dvd dvd1 = new Dvd("1dvd");
        dvd1.setReleaseDate(LocalDate.now());
        dvd1.setMpaaRating("arating");
        dvd1.setStudio("studio");
        dvd1.setUserComments("none");

        dao.addDvd(dvd1.getTitle(), dvd1);

        Dvd dvd2 = new Dvd("2dvd");
        dvd2.setReleaseDate(LocalDate.now());
        dvd2.setMpaaRating("anotherrating");
        dvd2.setStudio("anotherstudio");
        dvd2.setUserComments("some comment");

        dao.addDvd(dvd2.getTitle(), dvd2);

        //Act/Assert
        assertEquals(2, dao.getAllDvds().size());
    }

    /**
     * Test of removeDvd method, of class DvdLibraryFileImpl.
     */
    @Test
    public void testRemoveDvd() throws Exception {
        //Arrange
        Dvd dvd1 = new Dvd("1dvd");
        dvd1.setReleaseDate(LocalDate.now());
        dvd1.setMpaaRating("arating");
        dvd1.setStudio("studio");
        dvd1.setUserComments("none");

        dao.addDvd(dvd1.getTitle(), dvd1);

        Dvd dvd2 = new Dvd("2dvd");
        dvd2.setReleaseDate(LocalDate.now());
        dvd2.setMpaaRating("anotherrating");
        dvd2.setStudio("anotherstudio");
        dvd2.setUserComments("some comment");

        dao.addDvd(dvd2.getTitle(), dvd2);

        //Act/Assert
        dao.removeDvd(dvd1.getTitle());
        assertEquals(1, dao.getAllDvds().size());
        assertNull(dao.getDvd(dvd1.getTitle()));

        //Act/Assert
        dao.removeDvd(dvd2.getTitle());
        assertEquals(0, dao.getAllDvds().size());
        assertNull(dao.getDvd(dvd2.getTitle()));

    }

    /**
     * Test of editDvd method, of class DvdLibraryFileImpl.
     */
    @Test
    public void testEditDvd() throws Exception {
        //Arrange
        Dvd dvd1 = new Dvd("1dvd");
        dvd1.setReleaseDate(LocalDate.parse("2019-07-23"));
        dvd1.setMpaaRating("arating");
        dvd1.setStudio("studio");
        dvd1.setUserComments("none");

        dao.addDvd(dvd1.getTitle(), dvd1);

        Dvd fromDao = dao.getDvd(dvd1.getTitle());

        //Act
        dao.editDvd(dvd1.getTitle(), dvd1);
        dvd1.setMpaaRating("4");

        //Assert
        assertEquals(dvd1, fromDao);

    }

    @Test
    public void testMovieInLastYears() throws DvdLibraryDaoException {

        //Arrange
        Dvd dvd1 = new Dvd("1dvd");
        dvd1.setReleaseDate(LocalDate.now());
        dvd1.setMpaaRating("arating");
        dvd1.setStudio("studio");
        dvd1.setUserComments("none");

        dao.addDvd(dvd1.getTitle(), dvd1);

        Dvd dvd2 = new Dvd("2dvd");
        dvd2.setReleaseDate(LocalDate.of(1999, Month.MARCH, 21));
        dvd2.setMpaaRating("anotherrating");
        dvd2.setStudio("anotherstudio");
        dvd2.setUserComments("some comment");

        dao.addDvd(dvd2.getTitle(), dvd2);

        //Act
        List<Dvd> dvdList = dao.movieInLastYears(5);
        //Assert

        assertEquals(dvdList.size(), 1);
    }

    @Test
    public void testGetAverageAge() throws DvdLibraryDaoException {

        //Arrange
        Dvd dvd1 = new Dvd("1dvd");
        dvd1.setReleaseDate(LocalDate.now());
        dvd1.setMpaaRating("arating");
        dvd1.setStudio("studio");
        dvd1.setUserComments("none");

        dao.addDvd(dvd1.getTitle(), dvd1);

        Dvd dvd2 = new Dvd("2dvd");
        dvd2.setReleaseDate(LocalDate.of(1999, Month.MARCH, 21));
        dvd2.setMpaaRating("anotherrating");
        dvd2.setStudio("anotherstudio");
        dvd2.setUserComments("some comment");

        dao.addDvd(dvd2.getTitle(), dvd2);

        double other = (dvd1.getAgeInYears() + dvd2.getAgeInYears()) / 2;

        //Act
        double testAverage = dao.getAverageAge();

        //Assert
        assertEquals(other, testAverage, 0.0);
    }

    @Test
    public void getNewestMovie() throws DvdLibraryDaoException {
        //Arrange
        Dvd dvd1 = new Dvd("1dvd");
        dvd1.setReleaseDate(LocalDate.now());
        dvd1.setMpaaRating("arating");
        dvd1.setStudio("studio");
        dvd1.setUserComments("none");

        dao.addDvd(dvd1.getTitle(), dvd1);

        Dvd dvd2 = new Dvd("2dvd");
        dvd2.setReleaseDate(LocalDate.of(1999, Month.MARCH, 21));
        dvd2.setMpaaRating("anotherrating");
        dvd2.setStudio("anotherstudio");
        dvd2.setUserComments("some comment");

        dao.addDvd(dvd2.getTitle(), dvd2);

        //Act
        List<Dvd> dvdList = dao.getNewestMovie();

        //Assert
        assertEquals(dvdList.get(0).getReleaseDate(), dvd1.getReleaseDate());
    }

    @Test
    public void getOldestMovie() throws DvdLibraryDaoException {
        //Arrange
        Dvd dvd1 = new Dvd("1dvd");
        dvd1.setReleaseDate(LocalDate.now());
        dvd1.setMpaaRating("arating");
        dvd1.setStudio("studio");
        dvd1.setUserComments("none");

        dao.addDvd(dvd1.getTitle(), dvd1);

        Dvd dvd2 = new Dvd("2dvd");
        dvd2.setReleaseDate(LocalDate.of(1999, Month.MARCH, 21));
        dvd2.setMpaaRating("anotherrating");
        dvd2.setStudio("anotherstudio");
        dvd2.setUserComments("some comment");

        dao.addDvd(dvd2.getTitle(), dvd2);

        //Act
        List<Dvd> dvdList = dao.getNewestMovie();

        //Assert
        assertEquals(dvdList.get(1).getReleaseDate(), dvd2.getReleaseDate());

    }

    @Test
    public void findAverageNumberOfNote() throws DvdLibraryDaoException {
        //Arrange
        Dvd dvd1 = new Dvd("1dvd");
        dvd1.setReleaseDate(LocalDate.now());
        dvd1.setMpaaRating("arating");
        dvd1.setStudio("studio");
        dvd1.setUserComments("none");

        dao.addDvd(dvd1.getTitle(), dvd1);

        Dvd dvd2 = new Dvd("2dvd");
        dvd2.setReleaseDate(LocalDate.of(1999, Month.MARCH, 21));
        dvd2.setMpaaRating("anotherrating");
        dvd2.setStudio("anotherstudio");
        dvd2.setUserComments(" ");

        dao.addDvd(dvd2.getTitle(), dvd2);
        //Act
        double notes = dao.findAverageNumberOfNote();
        double number = .5;
        //Assert
        assertEquals(number, notes, 0.0);

    }

}
