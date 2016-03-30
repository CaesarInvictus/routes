/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routes;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author shecharya
 */
public class Calendar {
    private List<Flight> Cal = new ArrayList<Flight>();
    
    public Calendar(){
    this.Cal = Cal;
    
}//Calendar
    public boolean insert(Flight flight){
        if (this.Cal.isEmpty()){
            this.Cal.add(flight);
            return true;
        }//if
        int flighttime = flight.departTime();
        for(int i=0; i<this.Cal.size(); i++){
            if (this.Cal.get(i).departTime()>flighttime){
                this.Cal.add(i, flight);
                return true;
                
            }//if
            
        }//for
        this.Cal.add(flight);
        return true;
       
        
    }//add()
    
}
