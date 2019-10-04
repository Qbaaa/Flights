package com.qbaaa.flights.Model;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Table(name = "flights")
public abstract class Flight
{
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    protected long id;
    protected TypeFlight type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "flights_startairport",
            joinColumns = {@JoinColumn(name = "start_airport_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "aiportId", referencedColumnName = "id", insertable = false, updatable = false)})
    protected Airport startAirport;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "flights_endairport",
            joinColumns = {@JoinColumn(name = "end_airport_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "aiportId", referencedColumnName = "id", insertable = false, updatable = false)})
    protected Airport endAirport;
    protected LocalTime startTime;
    protected int durationTimeMinutes;


    public Flight() {}

    public Flight(long id, TypeFlight type, Airport startAirport, Airport endAirport, LocalTime startTime, int durationTimeMinutes) {
        this.id = id;
        this.type = type;
        this.startAirport = startAirport;
        this.endAirport = endAirport;
        this.startTime = startTime;
        this.durationTimeMinutes = durationTimeMinutes;
    }


    public long getId() {
        return id;
    }

    public TypeFlight getType() {
        return type;
    }

    public Airport getStartAirport() {
        return startAirport;
    }

    public Airport getEndAirport() {
        return endAirport;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public int getDurationTimeMinutes() {
        return durationTimeMinutes;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(TypeFlight type) {
        this.type = type;
    }

    public void setStartAirport(Airport startAirport) {
        this.startAirport = startAirport;
    }

    public void setEndAirport(Airport endAirport) {
        this.endAirport = endAirport;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setDurationTimeMinutes(int durationTimeMinutes) {
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
