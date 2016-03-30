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
    public double departTime(){
        return Double.parseDouble(this.flight.get(2));
    }//absTime
    public double flightTime(){
        return Double.parseDouble(this.flight.get(3));
    }//flightTime()
    public boolean makeConnection(Flight f){
        return this.departTime()+this.flightTime()<f.departTime();
    }//makeConnection
    
    
}//Flight
