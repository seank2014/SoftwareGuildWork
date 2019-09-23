package shape;


import shape.Circle;
import shape.Rectangle;
import shape.Shape;
import shape.Square;
import shape.Triangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author seanking
 */
public class App {
    
    public static void main(String[] args) {
        
        double pie = 3.14;
        double radius = 8;
        double circleArea = pie *( radius * radius);
        double circlePerimeter = (2* pie * radius);
        
        Shape myRectangle = new Rectangle();
        myRectangle.setColor("Brown");//when is put it was square first, it returned "null". Why?
        System.out.println("The rectangle is " + myRectangle.getColor() + " and it's perimeter is " + myRectangle.getPerimeter() + " and it's area is " + myRectangle.getArea());
        
        
        Shape mySquare = new Square();
        mySquare.setColor("Yellow");
        System.out.println("The square is " + mySquare.getColor() + " and it's periemeter is " + mySquare.getPerimeter() + " and it's area is " + mySquare.getArea());
        
        
        Shape myTriangle = new Triangle();
        myTriangle.setColor("Blue");
        System.out.println("The triangle is " + myTriangle.getColor() + " and it's perimeter is " + myTriangle.getPerimeter() + " and it's area is " + myTriangle.getArea());
        
       Shape myCircle = new Circle();
       myCircle.setColor("Lavender");
       
        System.out.println("The circle is " + myCircle.getColor() + " and it's perimeter is " + circlePerimeter + " and it's area is " + circleArea);
    
}
    
}
