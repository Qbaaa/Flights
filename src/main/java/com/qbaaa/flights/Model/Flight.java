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

    @ManyToOne
    @JoinColumn(name = "start_airport_id")
    protected Airport start;

    @ManyToOne
    @JoinColumn(name = "end_airport_id")
    protected Airport end ;

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

    public LocalTime getStartTime() { return startTime; }

    public Long getDurationTimeMinutes() { return durationTimeMinutes; }

    public void setId(Long id) { this.id = id; }

    public void setType(TypeFlight type) {
        this.type = type;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setDurationTimeMinutes(Long durationTimeMinutes) {
        this.durationTimeMinutes = durationTimeMinutes;
    }

    public Airport getStart() { return start; }

    public void setStart(Airport start) { this.start = start; }

    public Airport getEnd() { return end; }

    public void setEnd(Airport end) { this.end = end; }

    @Override
    public String toString() {
        return "type=" + type +
                ", startAirport=" + start +
                ", endAirport=" + end +
                ", startTime=" + startTime +
                ", durationTimeMinutes=" + durationTimeMinutes ;
    }
}
