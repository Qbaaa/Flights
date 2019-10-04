package com.qbaaa.flights.Model;

import javax.persistence.*;

@Entity
@Table(name = "airport")
public class Airport
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;
    private String nameCountry;

//    @OneToOne(mappedBy = "startAirport")
//    private Flight start;
//
//    @OneToOne(mappedBy = "endAirport")
//    private Flight end;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

//    public Flight getStart() {
//        return start;
//    }
//
//    public void setStart(Flight start) {
//        this.start = start;
//    }

    @Override
    public String toString() {
        return "Airport{" +
                "  name='" + name + '\'' +
                ", nameCountry='" + nameCountry + '\'' +
                '}';
    }
}
