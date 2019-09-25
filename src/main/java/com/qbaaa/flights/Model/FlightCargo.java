package com.qbaaa.flights.Model;

import java.time.LocalTime;

public class FlightCargo extends Flight {

    public double feeConst;
    public double feeForKiloPack;

    public FlightCargo() {}

    public FlightCargo(long id, Airport startAirport, Airport endAirport, LocalTime startTime, int durationTimeMinutes, double feeConst, double feeForKiloPack) {
        super(id, TypeFlight.cargo, startAirport, endAirport, startTime, durationTimeMinutes);
        this.feeConst = feeConst;
        this.feeForKiloPack = feeForKiloPack;
    }

    @Override
    public String toString() {
        return "FlightCargo{" +
                super.toString() +
                "feeConst=" + feeConst +
                ", feeForKiloPack=" + feeForKiloPack +
                '}';
    }
}
