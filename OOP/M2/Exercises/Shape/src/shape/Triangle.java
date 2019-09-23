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
public class Triangle extends Shape {
    
    
    
    @Override
    public int getArea(){
        return (15*7)/2;
    }
    
    
    @Override
    public int getPerimeter(){
        return 15+7+9;
    }
    
    
    
    
}
