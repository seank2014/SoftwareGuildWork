/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.dao;

import addressbook.dto.Address;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author seanking
 */
public class AddressBookDaoFileImplTest {
    
    AddressBookDao dao = new AddressBookDaoFileImpl();
    
    public AddressBookDaoFileImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws AddressBookDaoException {
        List <Address> book = dao.ListAllAddresses();
        for(Address address : book){
           dao.removeAddress(address.getLastName());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addAddress method, of class AddressBookDaoFileImpl.
     */
    @Test
    public void testAddGetAddress() throws Exception {
        
        //Arrange
        Address address = new Address("Lastname");
        address.setFirstName("firstname");
        address.setStreetName("street name");
        address.setCity("city");
        address.setState("state");
        address.setZipCode("12345");
        
        dao.addAddress(address.getLastName(), address);
         
         //Act 
         Address fromDao = dao.findAddress(address.getLastName());
         
        //Assert
        assertEquals(address, fromDao);
        
    }

    /**
     * Test of removeAddress method, of class AddressBookDaoFileImpl.
     */
    @Test
    public void testRemoveAddress() throws Exception {
         //Arrange
        Address address = new Address("Lastname");
        address.setFirstName("firstname");
        address.setStreetName("street name");
        address.setCity("city");
        address.setState("state");
        address.setZipCode("12345");
        
         dao.addAddress(address.getLastName(), address);
         
        Address address2 = new Address("ALastname");
        address2.setFirstName("Afirstname");
        address2.setStreetName("Astreet name");
        address2.setCity("Acity");
        address2.setState("Astate");
        address2.setZipCode("012345");
        
        dao.addAddress(address2.getLastName(), address2);
    
         
        //Act
        dao.removeAddress(address.getLastName());
        //Assert
        assertEquals( 1, dao.ListAllAddresses().size());
        assertNull(dao.findAddress(address.getLastName()));
        
        //Act
        dao.removeAddress(address2.getLastName());
        //Assert
        assertEquals( 0, dao.ListAllAddresses().size());
        assertNull(dao.findAddress(address2.getLastName()));

    }

    /**
     * Test of TotalNumber method, of class AddressBookDaoFileImpl.
     */
    @Test
    public void testTotalNumber() throws Exception {
         //Arrange
         Address address = new Address("Lastname");
        address.setFirstName("firstname");
        address.setStreetName("street name");
        address.setCity("city");
        address.setState("state");
        address.setZipCode("12345");
        
         dao.addAddress(address.getLastName(), address);
         
        Address address2 = new Address("ALastname");
        address2.setFirstName("Afirstname");
        address2.setStreetName("Astreet name");
        address2.setCity("Acity");
        address2.setState("Astate");
        address2.setZipCode("012345");
        
        dao.addAddress(address2.getLastName(), address2);
        //Act
        int total = dao.TotalNumber();
        //Assert
        assertEquals(2,total);
    }

    /**
     * Test of ListAllAddresses method, of class AddressBookDaoFileImpl.
     */
    @Test
    public void testListAllAddresses() throws Exception {
         //Arrange
        Address address = new Address("Lastname");
        address.setFirstName("firstname");
        address.setStreetName("street name");
        address.setCity("city");
        address.setState("state");
        address.setZipCode("12345");
        
         dao.addAddress(address.getLastName(), address);
         
        Address address2 = new Address("ALastname");
        address2.setFirstName("Afirstname");
        address2.setStreetName("Astreet name");
        address2.setCity("Acity");
        address2.setState("Astate");
        address2.setZipCode("012345");
        
         dao.addAddress(address2.getLastName(), address2);
        //Act//Assert
        assertEquals(2, dao.ListAllAddresses().size());
    }

    /**
     * Test of editAddress method, of class AddressBookDaoFileImpl.
     */
    @Test
    public void testEditAddress() throws Exception {
         //Arrange
        Address address = new Address("Lastname");
        address.setFirstName("firstname");
        address.setStreetName("street name");
        address.setCity("city");
        address.setState("state");
        address.setZipCode("12345");
        dao.addAddress(address.getLastName(), address);
         
         Address fromDao = dao.findAddress(address.getLastName());
         assertEquals(address, fromDao);

        //Act
         address.setFirstName("newFirstName");
        dao.editAddress(address.getLastName(), address);
        
        //Assert
        assertEquals(fromDao, address);
    }
    
}
