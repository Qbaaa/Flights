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
    protected Long id;
    protected TypeFlight type;


    @OneToOne
    @JoinColumn(name = "id_start_airport")
    protected Airport start;

    @OneToOne
    @JoinColumn(name = "id_end_airport")
    protected Airport end;

    protected LocalTime startTime;
    protected Long durationTimeMinutes;


    public Flight() {}

    public Flight(TypeFlight type, Airport startAirport, Airport endAirport, LocalTime startTime, Long durationTimeMinutes) {
        this.type = type;
        this.start = startAirport;
        this.end = endAirport;
        this.startTime = startTime;
        this.durationTimeMinutes = durationTimeMinutes;
    }

    public Long getId() { return id; }

    public TypeFlight getType() { return type; }

    public Airport getStartAirport() { return start; }

    public Airport getEndAirport() { return end; }

    public LocalTime getStartTime() { return startTime; }

    public Long getDurationTimeMinutes() { return durationTimeMinutes; }

    public void setId(Long id) { this.id = id; }

    public void setType(TypeFlight type) {
        this.type = type;
    }

    public void setStartAirport(Airport startAirport) {
        this.start = startAirport;
    }

    public void setEndAirport(Airport endAirport) {
        this.end = endAirport;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setDurationTimeMinutes(Long durationTimeMinutes) {
        this.durationTimeMinutes = durationTimeMinutes;
    }


    @Override
    public String toString() {
        return "type=" + type +
                ", startAirport=" + start +
                ", endAirport=" + end +
                ", startTime=" + startTime +
                ", durationTimeMinutes=" + durationTimeMinutes ;
    }
}
