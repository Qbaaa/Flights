package com.qbaaa.flights.Service;

import com.qbaaa.flights.Model.Flight;
import java.util.Comparator;

public class FlightTimeStartComparator implements Comparator<Flight> {
    @Override
    public int compare(Flight o1, Flight o2) {
        return o1.getStartTime().compareTo(o2.getStartTime());
    }
}
