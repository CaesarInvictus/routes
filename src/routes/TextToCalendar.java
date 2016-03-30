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

/**
 *
 * @author shecharya
 */
public class TextToCalendar {
    private String arrival;
    private String departure;
    private String departTime;
    private String flightTime;
    private Flight thisFlight;
    private Calendar Cal;

    public TextToCalendar() {
        this.Cal = Cal;
    }//TextToCalendar
    public Calendar gibCalendar(String fileName){
        In inputStream = new In(fileName);

        // number of bodies
        while (inputStream.hasNextLine()){
            arrival = inputStream.readString();
            departure = inputStream.readString();
            departTime = inputStream.readString();
            flightTime = inputStream.readString();
            thisFlight = new Flight(arrival, departure, departTime, flightTime);
            this.Cal.insert(thisFlight);
            
        }//while
        return Cal;
    }//gibCalendar()
}//TextToCalendar