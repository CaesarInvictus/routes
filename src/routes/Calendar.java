/*
 * Copyright (C) 2016 shecharya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package routes;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author shecharya
 */
/**
 * Creates a sorted list of flights. Flights are sorted by departure time.
 * 
 * @author shecharya
 */
public class Calendar {
    private List<Flight> Cal = new ArrayList<Flight>();
    
    public Calendar(){
    this.Cal = Cal;
    
}//Calendar
/**
*
*Inserts a flight into the Calendar in order of departure time
* @param flight the flight to insert
* @return true if succeeds
* 
*/
    public boolean insert(Flight flight){
        if (this.Cal.isEmpty()){
            this.Cal.add(flight);
            return true;
        }//if
        double flighttime = flight.departTime();
        for(int i=0; i<this.Cal.size(); i++){
            if (this.Cal.get(i).departTime()>flighttime){
                this.Cal.add(i, flight);
                return true;
                
            }//if
            
        }//for
        this.Cal.add(flight);
        return true;
       
        
    }//add()
    /**
     * 
     * Gets the flight at position i in the calendar
     * @param i The position in the calendar to retrieve
     * @return The flight in the calendar at position i
     */
    public Flight getFlight(int i){
        return Cal.get(i);
    }
    /**
     * Returns the size of the calendar
     * @return The size of the list Cal 
     */
    public int size(){
        return Cal.size();
    }
}
