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
public abstract class Shape {

    /**
     * @param args the command line arguments
     */
    
    protected int Area;
    protected int Perimeter;
    protected String color;

    
    
    public int getArea() {
        return Area;
    }

    public int getPerimeter() {
        return Perimeter;
    }

    
    public String getColor() {
        return color;
    }
    
        public void setColor(String color) {
        this.color = color;
    }
    
    
}
