/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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