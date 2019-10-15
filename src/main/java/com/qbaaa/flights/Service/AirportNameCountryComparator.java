package com.qbaaa.flights.Service;

import com.qbaaa.flights.Model.Airport;

import java.util.Comparator;

public class AirportNameCountryComparator implements Comparator<Airport>
{

    @Override
    public int compare(Airport o1, Airport o2) {
        return o1.getNameCountry().compareTo(o2.getNameCountry());
    }
}
