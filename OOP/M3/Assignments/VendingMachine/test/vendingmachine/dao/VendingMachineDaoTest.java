/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.dao;

import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import vendingmachine.dto.Item;

/**
 *
 * @author seanking
 */
public class VendingMachineDaoTest {

    private VendingMachineDao dao = new VendingMachineDaoFileImpl();

    public VendingMachineDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<Item> itemList = dao.getAllItems();
        for (Item item : itemList) {
            dao.deleteItem(item.getItemId());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAddItem method, of class VendingMachineDao.
     */
    @Test
    public void testAddGetItem() throws Exception {
        Item firstItem = new Item(1);
        firstItem.setName("Gummy Bears");
        firstItem.setQty(4);
        firstItem.setPrice(BigDecimal.ONE);
        
        dao.addItem(firstItem.getItemId(), firstItem);
        
        Item fromDao = dao.getItemById(firstItem.getItemId());
        
        assertEquals(firstItem, fromDao);
    }

    /**
     * Test of getAllItems method, of class VendingMachineDao.
     */
    @Test
    public void testGetAllItems() throws Exception {

        Item firstItem = new Item(1);
        firstItem.setName("Gummy Bears");
        firstItem.setQty(4);
        firstItem.setPrice(new BigDecimal("3.00"));
        dao.addItem(firstItem.getItemId(), firstItem);

        Item secondItem = new Item(2);
        secondItem.setName("Juice");
        secondItem.setQty(5);
        secondItem.setPrice(new BigDecimal("4.00"));
        dao.addItem(secondItem.getItemId(), secondItem);

        Item thirdItem = new Item(3);
        thirdItem.setName("Snickers");
        thirdItem.setQty(12);
        thirdItem.setPrice(new BigDecimal("1.25"));
        dao.addItem(thirdItem.getItemId(), thirdItem);

        Item fourthItem = new Item(4);
        fourthItem.setName("Oreos");
        fourthItem.setQty(0);
        fourthItem.setPrice(new BigDecimal("1.25"));
        dao.addItem(fourthItem.getItemId(), fourthItem);

        Item fifthItem = new Item(5);
        fifthItem.setName("M&Ms");
        fifthItem.setQty(10);
        fifthItem.setPrice(new BigDecimal("1.00"));
        dao.addItem(fifthItem.getItemId(), fifthItem);

        Item sixthItem = new Item(6);
        sixthItem.setName("Soda");
        sixthItem.setQty(7);
        sixthItem.setPrice(new BigDecimal("1.50"));
        dao.addItem(sixthItem.getItemId(), sixthItem);
        
        Item seventhItem = new Item(7);
        seventhItem.setName("Ritz");
        seventhItem.setQty(6);
        seventhItem.setPrice(new BigDecimal(".75"));
        dao.addItem(seventhItem.getItemId(), seventhItem);
        
        Item eigthItem = new Item(8);
        eigthItem.setName("Pretzels");
        eigthItem.setQty(10);
        eigthItem.setPrice(new BigDecimal("1.50"));
        dao.addItem(eigthItem.getItemId(), eigthItem);

        
        assertEquals(8, dao.getAllItems().size());
    }



    /**
     * Test of updateItem method, of class VendingMachineDao.
     */
    @Test
    public void testUpdateItem() throws Exception {
        
        Item firstItem = new Item(1);
        firstItem.setName("Gummy Bears");
        firstItem.setQty(4);
        firstItem.setPrice(new BigDecimal("3.00"));
        dao.addItem(firstItem.getItemId(), firstItem);
        
        Item fromDao = dao.getItemById(firstItem.getItemId());
        
        assertEquals(fromDao, firstItem);
        
         firstItem.setQty(3);
         dao.updateItem(firstItem.getItemId());
       
         assertEquals(fromDao, firstItem);       
    }

    /**
     * Test of deleteItem method, of class VendingMachineDao.
     */
    @Test
    public void testDeleteItem() throws Exception {
        Item firstItem = new Item(1);
        firstItem.setName("Gummy Bears");
        firstItem.setQty(4);
        firstItem.setPrice(new BigDecimal("3.00"));
        
        dao.addItem(firstItem.getItemId(), firstItem);
                
        dao.deleteItem(firstItem.getItemId());
        
        assertNull(dao.getItemById(firstItem.getItemId()));
    }

}
