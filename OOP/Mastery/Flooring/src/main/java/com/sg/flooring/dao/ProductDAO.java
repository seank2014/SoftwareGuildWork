/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dto.Product;
import java.util.List;

/**
 *
 * @author seanking
 */
public interface ProductDAO {
    
    Product getProductByProductType(String productType) 
            throws FlooringPersistenceException;
    
    List<Product>getAllProducts()
            throws FlooringPersistenceException;
    
    
}
