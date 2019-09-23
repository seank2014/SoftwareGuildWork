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
public class Circle extends Shape {
    
    @Override
    public int getArea(){
        int radius = 8;
        
        return 3 * (radius * radius);
        
    }
    
    @Override
    public int getPerimeter(){
        
        return (2 * 3 * 8);
    }
        
    
}
