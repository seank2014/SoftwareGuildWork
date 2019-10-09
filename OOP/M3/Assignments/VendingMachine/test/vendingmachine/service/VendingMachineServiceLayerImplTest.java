/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import vendingmachine.dao.VendingMachineAuditDao;
import vendingmachine.dao.VendingMachineAuditDaoStubImpl;
import vendingmachine.dao.VendingMachineDao;
import vendingmachine.dao.VendingMachineDaoStubImpl;
import vendingmachine.dto.Change;
import vendingmachine.dto.Item;

/**
 *
 * @author seanking
 */
public class VendingMachineServiceLayerImplTest {
    
    private VendingMachineServiceLayer service;
    
    public VendingMachineServiceLayerImplTest() {
        VendingMachineDao dao = new VendingMachineDaoStubImpl();
        VendingMachineAuditDao audit = new VendingMachineAuditDaoStubImpl();
        
        service = new VendingMachineServiceLayerImpl(dao, audit);
    }
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of selectItem method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testSelectItem() throws Exception {
        Item firstItem = service.selectItem(14);
        assertNotNull(firstItem);
        firstItem = service.selectItem(12);
        assertNull(firstItem);
    }

    /**
     * Test of getAllItems method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testGetAllItems() throws Exception {
        assertEquals(1, service.getAllItems().size());
    }

    /**
     * Test of purchaseItem method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testPurchaseItemAndDepositChange() throws Exception {
        BigDecimal money = new BigDecimal("2.75");
        Item firstItem = service.selectItem(14);
        Change newChange = service.purchaseItem(firstItem.getItemId(), money);
        
        assertEquals(1, newChange.getQuarter());
        
        
    }

    /**
     * Test of updateItem method, of class VendingMachineServiceLayerImpl.
     */
    @Test
    public void testUpdateItem() throws Exception {
        Item firstItem = service.selectItem(14);
        assertNotNull(firstItem);
        firstItem.setQty(4);
        service.updateItem(firstItem.getItemId());
        
        assertEquals(4, firstItem.getQty());
    }
    
}
