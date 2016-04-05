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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Scrapes <a href="http://flightaware.com/">Flightaware</a> for a list of air flights
 * @author shecharya
 */
public class Scrape {
    private Document doc;
    private Flight flight;
    private String date;
    private String airport;
    private Map<String, Double> map;
    private int flag;
    public Scrape(){
        this.doc = doc;
        this.flight = flight;
        this.map = new HashMap<String, Double>();
        this.flag = flag;
        
    }//Scrape()
    /**
     * Creates the URL we will attempt to grab. We need to be able to change the airport and iterate through pages.
     * @param offset Multiple of 20. The site returns tables of 20 rows so we need several page grabs to get all flights for an airport.
     * @return The URL we have generated
     */
    public String urlGen(int offset){
        return "http://flightaware.com/live/airport/" + airport + "/scheduled?;offset=" + offset + ";order=filed_departuretime;sort=ASC";
    } //urlGen
    /**
     * Creates a map of time zones to their <a href="https://en.wikipedia.org/wiki/List_of_time_zone_abbreviations">UTC offset</a>. The airport reports times by timezone. We need to correct the time or our connection data and flight times will be bad.
     * @return The map of time zones to UTC.
     */
    public Map genMap(){
        this.map.put("UTC", 0.0);
        this.map.put("ACDT", 10.5);
        this.map.put("ACST", 9.5);
        this.map.put("ACT", 8.0);
        this.map.put("ADT", -3.0);
        this.map.put("AEDT", 11.0);
        this.map.put("AEST", 10.0);
        this.map.put("AFT", 4.5);
        this.map.put("AKDT", -8.0);
        this.map.put("AKST", -9.0);
        this.map.put("AMST", -3.0);
        this.map.put("AMT", -4.0);
        this.map.put("ART", -3.0);
        this.map.put("AST", -4.0);
        this.map.put("AWDT", 9.0);
        this.map.put("AWST", 8.0);
        this.map.put("AZOST", -1.0);
        this.map.put("AZT", 4.0);
        this.map.put("BDT", 8.0);
        this.map.put("BIOT", 6.0);
        this.map.put("BIT", -12.0);
        this.map.put("BOT", -4.0);
        this.map.put("BRST", -2.0);
        this.map.put("BRT", -3.0);
        this.map.put("BST", 6.0);
        this.map.put("CAT", 2.0);
        this.map.put("CCT", 6.5);
        this.map.put("CDT", -5.0);
        this.map.put("CEDT", 2.0);
        this.map.put("CEST", 2.0);
        this.map.put("CET", 1.0);
        this.map.put("CHADT", 13.75);
        this.map.put("CHAST", 12.75);
        this.map.put("CHOT", 8.0);
        this.map.put("CHST", 10.0);
        this.map.put("CHUT", 10.0);
        this.map.put("CIST", -8.0);
        this.map.put("CIT", 8.0);
        this.map.put("CKT", -10.0);
        this.map.put("CLST", -3.0);
        this.map.put("CLT", -4.0);
        this.map.put("COST", -4.0);
        this.map.put("COT", -5.0);
        this.map.put("CST", -6.0);
        this.map.put("CT", 8.0);
        this.map.put("CVT", -1.0);
        this.map.put("CWST", 8.75);
        this.map.put("CXT", 7.0);
        this.map.put("DAVT", 7.0);
        this.map.put("DDUT", 10.0);
        this.map.put("DFT", 1.0);
        this.map.put("EASST", -5.0);
        this.map.put("EAST", -6.0);
        this.map.put("EAT", 3.0);
        this.map.put("ECT", -4.0);
        this.map.put("EDT", -4.0);
        this.map.put("EEDT", 3.0);
        this.map.put("EEST", 3.0);
        this.map.put("EET", 2.0);
        this.map.put("EGST", 0.0);
        this.map.put("EGT", -1.0);
        this.map.put("EIT", 9.0);
        this.map.put("EST", -5.0);
        this.map.put("FET", 3.0);
        this.map.put("FJT", 12.0);
        this.map.put("FKST", -3.0);
        this.map.put("FKT", -4.0);
        this.map.put("FNT", -2.0);
        this.map.put("GALT", -6.0);
        this.map.put("GAMT", -9.0);
        this.map.put("GET", 4.0);
        this.map.put("GFT", -3.0);
        this.map.put("GILT", 12.0);
        this.map.put("GIT", -9.0);
        this.map.put("GMT", 0.0);
        this.map.put("GST", -2.0);
        this.map.put("GYT", -4.0);
        this.map.put("HADT", -9.0);
        this.map.put("HAEC", 2.0);
        this.map.put("HAST", -10.0);
        this.map.put("HKT", 8.0);
        this.map.put("HMT", 5.0);
        this.map.put("HOVT", 7.0);
        this.map.put("HST", -10.0);
        this.map.put("IBST", 0.0);
        this.map.put("ICT", 7.0);
        this.map.put("IDT", 3.0);
        this.map.put("IOT", 3.0);
        this.map.put("IRDT", 4.5);
        this.map.put("IRKT", 8.0);
        this.map.put("IRST", 3.5);
        this.map.put("IST", 5.5);
        this.map.put("JST", 9.0);
        this.map.put("KGT", 6.0);
        this.map.put("KOST", 11.0);
        this.map.put("KRAT", 7.0);
        this.map.put("KST", 9.0);
        this.map.put("LHST", 10.5);
        this.map.put("LINT", 14.0);
        this.map.put("MAGT", 12.0);
        this.map.put("MART", -9.5);
        this.map.put("MAWT", 5.0);
        this.map.put("MDT", -6.0);
        this.map.put("MET", 1.0);
        this.map.put("MEST", 2.0);
        this.map.put("MHT", 12.0);
        this.map.put("MIST", 11.0);
        this.map.put("MIT", -9.5);
        this.map.put("MMT", 6.5);
        this.map.put("MSK", 3.0);
        this.map.put("MST", -7.0);
        this.map.put("MUT", 4.0);
        this.map.put("MYT", 8.0);
        this.map.put("NCT", 11.0);
        this.map.put("NDT", -2.5);
        this.map.put("NFT", 11.0);
        this.map.put("NPT", 5.75);
        this.map.put("NST", 3.5);
        this.map.put("NT", -3.5);
        this.map.put("NUT", -11.0);
        this.map.put("NZDT", 13.0);
        this.map.put("NZST", 12.0);
        this.map.put("OMST", 6.0);
        this.map.put("ORAT", 5.0);
        this.map.put("PDT", -7.0);
        this.map.put("PET", -5.0);
        this.map.put("PETT", 12.0);
        this.map.put("PGT", 10.0);
        this.map.put("PHOT", 13.0);
        this.map.put("PKT", 5.0);
        this.map.put("PMDT", -2.0);
        this.map.put("PMST", -3.0);
        this.map.put("PONT", 11.0);
        this.map.put("PST", -8.0);
        this.map.put("PYST", -3.0);
        this.map.put("PYT", -4.0);
        this.map.put("RET", 4.0);
        this.map.put("ROTT", -3.0);
        this.map.put("SAKT", 11.0);
        this.map.put("SAMT", 4.0);
        this.map.put("SAST", 2.0);
        this.map.put("SBT", 11.0);
        this.map.put("SCT", 4.0);
        this.map.put("SGT", 8.0);
        this.map.put("SLST", 5.5);
        this.map.put("SRET", 11.0);
        this.map.put("SRT", -3.0);
        this.map.put("SST", 8.0);
        this.map.put("SYOT", 3.0);
        this.map.put("TAHT", -10.0);
        this.map.put("THA", 7.0);
        this.map.put("TFT", 5.0);
        this.map.put("TJT", 5.0);
        this.map.put("TKT", 13.0);
        this.map.put("TLT", 9.0);
        this.map.put("TMT", 5.0);
        this.map.put("TOT", 13.0);
        this.map.put("TVT", 12.0);
        this.map.put("ULAT", 8.0);
        this.map.put("USZ1", 2.0);
        this.map.put("UYST", -2.0);
        this.map.put("UYT", -3.0);
        this.map.put("UZT", 5.0);
        this.map.put("VET", -4.5);
        this.map.put("VLAT", 10.0);
        this.map.put("VOLT", 4.0);
        this.map.put("VOST", 6.0);
        this.map.put("VUT", 11.0);
        this.map.put("WAKT", 12.0);
        this.map.put("WAST", 2.0);
        this.map.put("WAT", 1.0);
        this.map.put("WEDT", 1.0);
        this.map.put("WEST", 1.0);
        this.map.put("WET", 0.0);
        this.map.put("WIT", 7.0);
        this.map.put("WST", 8.0);
        this.map.put("YAKT", 9.0);
        this.map.put("YEKT", 5.0);
        return this.map;
        
    }//genMap THERE ARE 24 POSSIBLE TIME ZONES WHY DO WE NEED 180 NAMES
    /**
     * Formats the time we grab from a website into a usable double.
     * @param time The string we get from the website.
     * @return The double-converted form of that time.
     */
    public double timeToDouble(String time){       
        String[] parts = time.split(" ");
        String[] timeparts = parts[1].split(":");
        String flagit = new String(parts[0]);
        String flagot = new String("Tue");
        double theTime = Double.parseDouble(timeparts[0]) + (Double.parseDouble(timeparts[1])/60.0);
        if (flagit.equals(flagot)){
            this.flag = 1;
        }
        return theTime + (this.map.get(parts[2]));
        
    }//timeToInt
    /**
     * Scrapes the website for a set of flights and inserts them into a {@link Calendar}. Does not currently work.
     * @return The Calendar we generate.
     */
    public Calendar getCal(){
        int offset = 0;
        this.flag = 0;
        List<String> tempList = new ArrayList<String>();
        Calendar cal = new Calendar();
        try{
            while (this.flag == 0){
                this.doc = Jsoup.connect(this.urlGen(offset)).get();  
                Elements rows = doc.select("tr");
                for (Element row : rows){
                    Elements vars = row.select("td");
                        for (Element var : vars){
                            tempList.add(var.text() + var.children().text());
                            
                        }
                        System.out.println(tempList);
                        Flight theflight = new Flight("JFK", tempList.get(2), timeToDouble(tempList.get(3)), timeToDouble(tempList.get(4)));
                        cal.insert(theflight);
                        
                }
                offset = offset + 20;

                
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return cal;
    }//getCal
    /**
     * Placeholder which creates a {@link Calendar} based on artificial data
     * @return The calendar of fake data
     */
    public Calendar fakeGetCal(){
        Calendar cal = new Calendar();
        List<Flight> flights = new ArrayList<Flight>();
        flights.add(new Flight("JFK", "MCO", 950, 2));
        flights.add(new Flight("ORD", "DEN", 800, 3));
        flights.add(new Flight("ORD", "HOU", 500, 1));
        flights.add(new Flight("ATL", "MCO", 950, 2));
        flights.add(new Flight("ORD", "HOU", 950, 3));
        flights.add(new Flight("DFW", "PHX", 950, 4));
        flights.add(new Flight("JFK", "ATL", 950, 2));
        flights.add(new Flight("ORD", "DFW", 950, 1));
        flights.add(new Flight("ORD", "PHX", 950, 3));
        flights.add(new Flight("ATL", "HOU", 950, 4));
        flights.add(new Flight("DEN", "PHX", 950, 2));
        flights.add(new Flight("PHX", "LAX", 950, 1));
        flights.add(new Flight("JFK", "ORD", 950, 1));
        flights.add(new Flight("DEN", "LAS", 950, 3));
        flights.add(new Flight("DFW", "HOU", 950, 4));
        flights.add(new Flight("ORD", "ATL", 950, 1));
        flights.add(new Flight("LAS", "LAX", 950, 2));
        flights.add(new Flight("ATL", "HOU", 950, 4));
        flights.add(new Flight("ATL", "HOU", 950, 3));
        flights.add(new Flight("ATL", "HOU", 950, 2));
        for(Flight f : flights){
            cal.insert(f);
        }
            return cal;   
    }//fakeGetCal
    /**
     * Test program in main
     * @param args 
     */
    public static void main(String[] args) {
        Scrape scrape = new Scrape();
        Calendar cal = scrape.fakeGetCal();
        System.out.println(cal);
        
    }
    
    
}//Scrape
