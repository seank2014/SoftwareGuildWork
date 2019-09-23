/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maybeitlovesme;

import java.util.Random;

/**
 *
 * @author seanking
 */
public class MaybeItLovesMe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Random randomizer = new Random();

int daisyP, i;
daisyP = randomizer.nextInt(89) + 13;



i = 0;




while(daisyP > i){
    daisyP--;
    
    if(daisyP % 2 == 0){
        System.out.println("It LOVES me!");
    }else{
        System.out.println("It loves me NOT!");
    }
    
    if( daisyP == 0){
        System.out.println("Oh, wow! It really LOVES me!");
    } else if (daisyP == i % 1){
        System.out.println("Awwww, bummer");
    }
    
    
    
    
  }
  }
      
  }
            





    
    
