package com.qbaaa.flights.Model;

import javax.persistence.*;
import java.time.LocalTime;


@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class Flight
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    public TypeFlight type;
    public Airport startAirport;
    public Airport endAirport;
    public LocalTime startTime;
    public int durationTimeMinutes;

    public long getId() {
        return id;
    }

    public Flight() {}

    public Flight(long id, TypeFlight type, Airport startAirport, Airport endAirport, LocalTime startTime, int durationTimeMinutes) {
        this.id = id;
        this.type = type;
        this.startAirport = startAirport;
        this.endAirport = endAirport;
        this.startTime = startTime;
        this.durationTimeMinutes = durationTimeMinutes;
    }

    @Override
    public String toString() {
        return "type=" + type +
                ", startAirport=" + startAirport +
                ", endAirport=" + endAirport +
                ", startTime=" + startTime +
                ", durationTimeMinutes=" + durationTimeMinutes ;
    }
}
