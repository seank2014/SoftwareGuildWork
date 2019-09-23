/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trivianight;

import java.util.Scanner;

/**
 *
 * @author seanking
 */
public class TriviaNight {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int answer1, answer2, answer3, answer4, answer5, answer6, totalPoints;
        String sanswer1, sanswer2, sanswer3, sanswer4, sanswer5, sanswer6;
        
        totalPoints=0;
        
        sanswer1 = "";
        sanswer2 = "";
        sanswer3 = "";
        sanswer4 = "";
        sanswer5 = "";
        sanswer6 = "";
        
        System.out.println("   Welcome to Trivia \n   ");
        System.out.println("   Below, you will be asked six question. Good luck! \n");
        
        Scanner myScanner = new Scanner(System.in);
        System.out.println("First question:\nWhat is the capital of New York?");
        System.out.println("\n 1) Albany         2) Rochester \n 3) Utica          4) Long Island");
        sanswer1 = myScanner.nextLine();
        answer1 = Integer.parseInt(sanswer1);
        
        System.out.println("You picked: \n" + sanswer1);
        
        System.out.println("Second question: \n What do call a dog when is it young?");
        System.out.println("\n 1) Whale           2) kitten \n 3)calf             4) Puppy");
        sanswer2 = myScanner.nextLine();
        answer2 = Integer.parseInt(sanswer2);
        
        System.out.println("You picked: \n" + answer2);
        
        System.out.println("Third question:\n What continent is the United states on?");
        System.out.println("\n 1) North America    2) Asia \n 3) Anartica          4) Europe");
        sanswer3 = myScanner.nextLine();
        answer3 = Integer.parseInt(sanswer3);
        
        System.out.println("You picked: \n" + answer3);
        
        System.out.println("Fourth question: \n What is pi?");
        System.out.println("\n 1) 3.14            2) 1.32 \n  3) 4.15              4) 5.73");
        sanswer4 = myScanner.nextLine();
        answer4 = Integer.parseInt(sanswer4);
        
        System.out.println("You picked: \n" + answer4);
        
        System.out.println("Fifth question: \n Where is Aruba located?");
        System.out.println("\n 1) Carribean       2) Central America \n 3)Baffin Bay 4) Java Sea");
        sanswer5 = myScanner.nextLine();
        answer5 = Integer.parseInt(sanswer5);
        
        System.out.println("You picked: \n" + answer5);
        
        System.out.println("Final question: \n Which is a character from Harry Potter?");
        System.out.println("\n 1) Harry Potter    2) Waldo \n 3) Bob Belcher       5) Panda");
    sanswer6= myScanner.nextLine();
    answer6=Integer.parseInt(sanswer6);
   
    if (answer1 == 1){
    
        totalPoints += 1;
    }
    if (answer2 == 4) {
    totalPoints += 1;
    }
    if(answer3 == 1){
        totalPoints += 1;
    }
    if(answer4 == 1){
        totalPoints += 1;
        }
    if(answer5 == 1){
        totalPoints += 1;
    }
    if(answer6 == 1){
        totalPoints += 1;
    }
        System.out.println("You have: " + totalPoints + " point(s)");
        
        if(totalPoints == 6){
            System.out.println("Way to rock the exam, you got all of them right!");
        }
        if(totalPoints == 0){
            System.out.println("Sorry, you didn't get anything right. Play again!");
        }
    }
        /*if(sanswer1 == "a") {
           
          sout
    }*/
    
}
