package com.qbaaa.flights.Service;

import com.qbaaa.flights.Model.Flight;

import java.time.LocalTime;
import java.util.Comparator;

public class FlightTimeEndComparator implements Comparator<Flight>
{

    @Override
    public int compare(Flight o1, Flight o2) {

        LocalTime ot1 = o1.getStartTime().plusMinutes(o1.getDurationTimeMinutes());
        LocalTime ot2 = o2.getStartTime().plusMinutes(o2.getDurationTimeMinutes());

        return ot1.compareTo(ot2);
    }
}
