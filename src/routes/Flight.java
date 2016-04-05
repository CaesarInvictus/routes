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
 * Creates a new Flight Object with starting and ending airports and departure and flight times. Can also check if one flight can "make a connection" with another flight.
 * @author shecharya
 */
public class Flight {
    private String fromAirport;
    private String toAirport;
    private double departTime;
    private double flightTime;
    /**
     * Creates the flight object.
     * @param fromAirport Set flight source airport
     * @param toAirport Set flight destination airport
     * @param departTime Set flight departure time
     * @param flightTime Set flight duration
     */
    public Flight(String fromAirport, String toAirport, double departTime, double flightTime){
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.departTime = departTime;
        this.flightTime = flightTime;
        
    }//Flight()
    /**
     * Returns departure time.
     * @return the departure time for this flight
     */
    public double departTime(){
        return this.departTime;

    }//absTime
    /**
     * Returns flight duration
     * @return The duration of this flight
     */
    public double flightTime(){
        return this.flightTime;
    }//flightTime()
    /**
     * Returns the source airport
     * @return The airport the flight departs from
     */
    public String fromAirport(){
        return this.fromAirport;
    }
    /**
     * Returns the destination airport
     * @return The airport the flight arrives at
     */
    public String toAirport(){
        return this.toAirport;
    }
    /**
     * Compares two flights and sees if a connection can be made
     * @param f The flight to compare this to
     * @return True if a connection can be made, otherwise false.
     */
    public boolean makeConnection(Flight f){
        return this.departTime+this.flightTime<f.departTime;
    }//makeConnection
    
    
}//Flight
