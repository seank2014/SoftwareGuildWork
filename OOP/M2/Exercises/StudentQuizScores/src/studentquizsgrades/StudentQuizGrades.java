/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquizsgrades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author seanking
 */
public class StudentQuizGrades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //cant use int must use integer
        UserIOConsole Io = new UserIOConsole();

        Map<String, ArrayList<Integer>> students = new HashMap<>();

        students.put("John", new ArrayList<Integer>(Arrays.asList(65, 65, 80, 75)));
        String suser;

        Io.print("Welcome to student quiz!\n");

        do {

            int user = Io.readInt("              Menu\n"
                    + "1. View all student in directory \n"
                    + "2. Add student to the directory \n"
                    + "3. Remove student from the directory \n"
                    + "4. View list of grades for specific student \n"
                    + "5. View quiz average for specific student\n"
                    + "6. View total class average\n"
                    + "7. Exit", 1, 7);

            if (user == 1) {
                Io.print("\n All students in directory: \n");

                Set<String> keys = students.keySet();

                for (String student : keys) {
                   Io.print(student);
                    //This is for if you want to print the value of the key
//                System.out.println(students.get(student));
                }

                
            } else if (user == 2) {
                Io.print("Add student to directory: \n");
                suser = Io.readString("Student must have atleast four grades to be added to directory. \n Does the student meet this requirement? Enter 'Yes' or 'No'");
                if (suser.equals("Yes") || suser.equals("yes")) {
                    students.put(Io.readString("Enter name of Student"), new ArrayList<Integer>(Arrays.asList(Io.readInt("Enter a grade"), Io.readInt("Enter a grade"),Io.readInt("Enter a grade"),Io.readInt("Enter a grade"))));

                    Io.print("Students in directory are: " + students.toString());
                } else {
                    break;
                }
            } else if (user == 3) {
                Io.print("Remove student from directory: \n");
                students.remove(Io.readString("Enter the name of student you want to remove"));
                Io.print("Student removed");
            } else if (user == 4) {
                    //retrieve grades of specific student
                System.out.print(students.get(Io.readString("Enter the name of the student")));
            } else if (user == 5) {
                Io.print("Find average score: \n");

                double sum = 0;
                double avg = 0;

                suser = Io.readString("Enter the name of the student");

                for (double number : students.get(suser)) {
                    sum += number;
                }

                avg = sum / students.get(suser).size();

                Io.print(suser + "'s" + " average score is " + avg);

            } else if(user == 6){
                
                double sum = 0;
                double avg = 0;
                double totalValues = 0;
                
                
                Set<String> keys = students.keySet();
                
                for(String k: keys){
                   for(double number :students.get(k)){
                       sum += number;
                       totalValues++;
                   }
                }
                avg = sum/totalValues;
                Io.print("The average score for the class is " + avg);
            }
            else if (user == 7) {
                break;
            }

            suser = Io.readString("\nDo you want to keep going. Enter 'Yes' or 'No'");

        } while (suser.equals("Yes") || suser.equals("yes"));

        Io.print("Thanks for visiting the directory!");

    }

}
