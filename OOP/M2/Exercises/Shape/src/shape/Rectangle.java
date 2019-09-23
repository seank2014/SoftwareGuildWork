/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

/**
 *
 * @author seanking
 */
public class Rectangle extends Shape {
    
    @Override
    public int getArea(){
        return 7*8;
                
    }
    
    @Override 
    public int getPerimeter(){
        return 2*(7+8);
    }
    
    
    
}
