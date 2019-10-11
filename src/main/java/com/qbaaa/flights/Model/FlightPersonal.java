package com.qbaaa.flights.Model;

import javax.persistence.Entity;
import java.time.LocalTime;

@Entity
public class FlightPersonal extends Flight {

    private double priceForOnePlace;
    private double maxWightBaggageForOnePerson;

    public FlightPersonal() { }

    public FlightPersonal(Airport startAirport, Airport endAirport, LocalTime startTime, Long durationTimeMinutes, double priceForOnePlace, double maxwWightBaggageForOnePerson) {
        super(TypeFlight.personal, startAirport, endAirport, startTime, durationTimeMinutes);
        this.priceForOnePlace = priceForOnePlace;
        this.maxWightBaggageForOnePerson = maxwWightBaggageForOnePerson;
    }

    public double getPriceForOnePlace() {
        return priceForOnePlace;
    }

    public void setPriceForOnePlace(double priceForOnePlace) {
        this.priceForOnePlace = priceForOnePlace;
    }

    public double getMaxwWightBaggageForOnePerson() {
        return maxWightBaggageForOnePerson;
    }

    public void setMaxwWightBaggageForOnePerson(double maxwWightBaggageForOnePerson) {
        this.maxWightBaggageForOnePerson = maxwWightBaggageForOnePerson;
    }

    @Override
    public String toString() {
        return "FlightPersonal{" +
                super.toString() +
                ", priceForOnePlace=" + priceForOnePlace +
                ", maxwWightBaggageForOnePerson=" + maxWightBaggageForOnePerson +
                '}';
    }
}
