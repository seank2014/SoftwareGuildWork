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
public class Square extends Shape {
    
   @Override
    public int getPerimeter(){
        return 2 *(5+5);// not sure if there is a way to but variables in method
        
    }
    
    @Override
    public int getArea(){
        return 5*5;
    }
   

    
    
        
        
        
  
    
}
