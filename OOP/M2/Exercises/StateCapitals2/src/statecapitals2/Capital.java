/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals2;

/**
 *
 * @author seanking
 */
public class Capital {
      String Name;
        int Population;
        int SquareMileage;
        
        public Capital(String cName, int pop, int sM){
            this.Name = cName;
            this.Population = pop;
            this.SquareMileage = sM;   
        }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPopulation() {
        return Population;
    }

    public void setPopulation(int Population) {
        this.Population = Population;
    }

    public int getSquareMileage() {
        return SquareMileage;
    }

    public void setSquareMileage(int SquareMileage) {
        this.SquareMileage = SquareMileage;
    }
        
        
        
    
}
