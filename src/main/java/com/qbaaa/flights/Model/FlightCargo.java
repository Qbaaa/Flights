package com.qbaaa.flights.Model;

import javax.persistence.Entity;
import java.time.LocalTime;

@Entity
public class FlightCargo extends Flight {

    private double feeConst;
    private double feeForKiloPack;

    public FlightCargo() {}

    public FlightCargo(Airport startAirport, Airport endAirport, LocalTime startTime, Long durationTimeMinutes, double feeConst, double feeForKiloPack) {
        super(TypeFlight.cargo, startAirport, endAirport, startTime, durationTimeMinutes);
        this.feeConst = feeConst;
        this.feeForKiloPack = feeForKiloPack;
    }

    public double getFeeConst() {
        return feeConst;
    }

    public void setFeeConst(double feeConst) {
        this.feeConst = feeConst;
    }

    public double getFeeForKiloPack() {
        return feeForKiloPack;
    }

    public void setFeeForKiloPack(double feeForKiloPack) {
        this.feeForKiloPack = feeForKiloPack;
    }

    @Override
    public String toString() {
        return "FlightCargo{" +
                super.toString() +
                " ,feeConst=" + feeConst +
                ", feeForKiloPack=" + feeForKiloPack +
                '}';
    }
}
