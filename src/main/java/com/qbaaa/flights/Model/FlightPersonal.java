package com.qbaaa.flights.Model;

import java.time.LocalTime;

public class FlightPersonal extends Flight {

    public double priceForOnePlace;
    public double maxwWightBaggageForOnePerson;

    public FlightPersonal() {
    }

    public FlightPersonal(long id, Airport startAirport, Airport endAirport, LocalTime startTime, int durationTimeMinutes, double priceForOnePlace, double maxwWightBaggageForOnePerson) {
        super(id, TypeFlight.personal, startAirport, endAirport, startTime, durationTimeMinutes);
        this.priceForOnePlace = priceForOnePlace;
        this.maxwWightBaggageForOnePerson = maxwWightBaggageForOnePerson;
    }

    @Override
    public String toString() {
        return "FlightPersonal{" +
                super.toString() +
                "priceForOnePlace=" + priceForOnePlace +
                ", maxwWightBaggageForOnePerson=" + maxwWightBaggageForOnePerson +
                '}';
    }
}
