/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author shecharya
 */
public class Flight {
    private List<String> flight = new ArrayList<String>();
    public Flight(String arrival, String departure, String departTime, String flightTime){
        this.flight=flight;
        this.flight.add(arrival);
        this.flight.add(departure);
        this.flight.add(departTime);
        this.flight.add(flightTime);
        
    }//Flight()
    public int departTime(){
        return Integer.parseInt(this.flight.get(2));
    }//absTime
    public int flightTime(){
        return Integer.parseInt(this.flight.get(3));
    }//flightTime()
    public boolean makeConnection(Flight f){
        return this.departTime()+this.flightTime()<f.departTime();
    }//makeConnection
    
    
}//Flight
