package com.qbaaa.flights.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airport")
public class Airport
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nameCountry;

    @JsonIgnore
    @OneToMany(mappedBy = "start")
    private List<Flight> startA = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "end")
    private List<Flight> endA = new ArrayList<>();

    public Airport() { }

    public Airport(String name, String nameCountry) {
        this.name = name;
        this.nameCountry = nameCountry;
    }

    public void addFlightStart(Flight flight)
    {
        startA.add(flight);
    }

    public void addFlightEnd(Flight flight) { endA.add(flight); }

    public void removeFlightStart(Flight flight) { startA.remove(flight); }

    public void removeFlightEnd(Flight flight) { endA.remove(flight);}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public List<Flight> getStartA() { return startA; }

    public void setStartA(List<Flight> startA) { this.startA = startA; }

    public List<Flight> getEndA() { return endA; }

    public void setEndA(List<Flight> endA) { this.endA = endA; }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameCountry='" + nameCountry + '\'' +
                '}';
    }
}
