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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shecharya
 */
public class FlightTest {
        private static final double EPSILON = 1E-8;
    
    public FlightTest() {
    }

    /**
     * Test of departTime method, of class Flight.
     */
    @Test
    public void testDepartTime() {
        System.out.println("departTime");
        Flight instance = new Flight("LAX", "JFK", "12", "2");
        double expResult = 12;
        double result = instance.departTime();
        assertEquals(expResult, result, EPSILON);
    }

    /**
     * Test of flightTime method, of class Flight.
     */
    @Test
    public void testFlightTime() {
        System.out.println("flightTime");
        Flight instance = new Flight("LAX", "JFK", "12", "2");
        double expResult = 2;
        double result = instance.flightTime();
        assertEquals(expResult, result, EPSILON);
    }

    /**
     * Test of makeConnection method, of class Flight.
     */
    @Test
    public void testMakeConnection() {
        System.out.println("makeConnection");
        Flight f = new Flight("JFK", "ORL", "16", "2");
        Flight instance = new Flight("LAX", "JFK", "12", "2");
        boolean expResult = true;
        boolean result = instance.makeConnection(f);
        assertEquals(expResult, result);
    }
}