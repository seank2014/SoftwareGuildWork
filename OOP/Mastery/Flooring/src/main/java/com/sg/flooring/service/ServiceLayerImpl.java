/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.service;

import com.sg.flooring.dao.FlooringAuditDao;
import com.sg.flooring.dao.FlooringPersistenceException;
import com.sg.flooring.dao.OrderDAO;
import com.sg.flooring.dao.ProductDAO;
import com.sg.flooring.dao.TaxDAO;
import com.sg.flooring.dto.Order;
import com.sg.flooring.dto.Product;
import com.sg.flooring.dto.Tax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seanking
 */
public class ServiceLayerImpl implements ServiceLayer {

    private FlooringAuditDao auditDao;
    OrderDAO orderDao;
    ProductDAO productDao;
    TaxDAO taxDao;

    public ServiceLayerImpl(FlooringAuditDao auditDao, OrderDAO orderDao, ProductDAO productDao, TaxDAO taxDao) {
        this.orderDao = orderDao;
        this.auditDao = auditDao;
        this.productDao = productDao;
        this.taxDao = taxDao;
    }

    private Order updatedOrder;

    @Override
    public void createOrder(Order order)
            throws FlooringPersistenceException, InvalidDataException{

        if (orderDao.getOrderByNumber(order.getOrderNumber(), LocalDate.now()) != null) {
            throw new InvalidDataException("Error: Could not create order. Order Number "
                    + order.getOrderNumber()
                    + " already exists");
        }
        calculateTotal(order);
        validateOrderInfo(order);
        orderDao.createOrder(order.getOrderNumber(), order);
        auditDao.writeAuditEntry("Order " + order.getOrderNumber() + " was created on " + order.getOrderDate());

    }

    @Override
    public List<Order> getAllOrders() throws FlooringPersistenceException {
        return orderDao.getAllOrders();
    }

    private Order calculateTotal(Order order) throws FlooringPersistenceException {

        BigDecimal taxRate = new BigDecimal(0);
        BigDecimal area = order.getArea();
        List<Tax> taxes = taxDao.loadTaxes();
        List<Product> product = productDao.getAllProducts();

        if (area.compareTo(BigDecimal.ZERO) >= 0) {

            for (Tax t : taxes) {
                if (t.getState().equalsIgnoreCase(order.getState())) {
                    taxRate = t.getTaxRate();
                }
            }

            for (Product p : product) {

                if (p.getProductType().equalsIgnoreCase(order.getProductType())) {

                    BigDecimal costPerSqFt = (p.getCostPerSquareFoot());
                    BigDecimal laborPerSqFt = (p.getLaborCostPerSquareFoot());

                    BigDecimal materialCost = area.multiply(costPerSqFt).setScale(2, RoundingMode.HALF_UP);
                    BigDecimal laborCost = area.multiply(laborPerSqFt).setScale(2, RoundingMode.HALF_UP);

                    BigDecimal subTotal = materialCost.add(laborCost).setScale(2, RoundingMode.HALF_UP);

                    BigDecimal taxTotal = subTotal.multiply(taxRate).divide(new BigDecimal("100")).setScale(2, RoundingMode.HALF_UP);

                    BigDecimal total = subTotal.add(taxTotal).setScale(2, RoundingMode.HALF_UP);

                    order.setTaxRate(taxRate);
                    order.setArea(area);
                    order.setCostPerSquareFoot(costPerSqFt);
                    order.setLaborCostPerSquareFoot(laborPerSqFt);
                    order.setMaterialCost(materialCost);
                    order.setLaborCost(laborCost);
                    order.setTotalTax(taxTotal);
                    order.setTotal(total);
                }

            }

        }

        return order;
    }

    @Override
    public Order findOrder(String orderNumber) throws FlooringPersistenceException {
        LocalDate orderDate = LocalDate.now();
        Order updatedOrder = orderDao.getOrderByNumber(orderNumber, orderDate);
        return updatedOrder;
    }

    @Override
    public void saveCurrentWork(Order order) throws FlooringPersistenceException {
        try {    
            validateOrderInfo(order);
        } catch (InvalidDataException ex) {
            Logger.getLogger(ServiceLayerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    @Override
    public Order updateOrder(String orderNumber)
            throws FlooringPersistenceException {
        LocalDate orderDate = LocalDate.now();
        Order newOrder = orderDao.updateOrder(orderDate, orderNumber, updatedOrder);
        return newOrder;

    }

    @Override
    public Order deleteOrder(LocalDate orderDate, String orderNumber) throws FlooringPersistenceException {
        auditDao.writeAuditEntry("Order made on " + orderDate + " has been removed");
        return orderDao.deleteOrder(orderNumber, orderDate);
    }

    private void validateOrderInfo(Order order) throws
            InvalidDataException {
        if (order.getOrderNumber() == null
                || order.getOrderNumber().trim().length() == 0
                || order.getCustomerName() == null
                || order.getCustomerName().trim().length() == 0
                || order.getState() == null
                || order.getState().trim().length() == 0
                || order.getTaxRate() == null
                || order.getTaxRate().toString().trim().length() == 0
                || order.getProductType() == null
                || order.getProductType().trim().length() == 0
                || order.getArea() == null
                || order.getArea().toString().trim().length() == 0
                || order.getCostPerSquareFoot() == null
                || order.getCostPerSquareFoot().toString().trim().length() == 0
                || order.getLaborCostPerSquareFoot() == null
                || order.getLaborCostPerSquareFoot().toString().trim().length() == 0
                || order.getMaterialCost() == null
                || order.getMaterialCost().toString().trim().length() == 0
                || order.getLaborCost() == null
                || order.getLaborCost().toString().trim().length() == 0
                || order.getTotalTax() == null
                || order.getTotalTax().toString().trim().length() == 0
                || order.getTotal() == null
                || order.getTotal().toString().trim().length() == 0) {

            throw new InvalidDataException(
                    "ERROR: All fields [Company name, State, Product and Amount of material]");

        }
    }

}
