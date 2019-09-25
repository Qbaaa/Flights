package com.qbaaa.flights.Model;

import javax.persistence.*;

@Entity
@Table(name = "airport")
public class Airport
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    public String name;
    public String nameCountry;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "  name='" + name + '\'' +
                ", nameCountry='" + nameCountry + '\'' +
                '}';
    }
}
