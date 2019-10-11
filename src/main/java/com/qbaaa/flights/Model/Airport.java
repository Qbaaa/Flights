package com.qbaaa.flights.Model;

import javax.persistence.*;

@Entity
@Table(name = "airport")
public class Airport
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nameCountry;

    @OneToOne(mappedBy = "start")
    private Flight startA;

    @OneToOne(mappedBy = "end")
    private Flight endA;


    public Airport() { }

    public Airport(String name, String nameCountry) {
        this.name = name;
        this.nameCountry = nameCountry;
    }

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

    public Flight getStartA() {
        return startA;
    }

    public void setStartA(Flight startA) {
        this.startA = startA;
    }

    public Flight getEndA() {
        return endA;
    }

    public void setEndA(Flight endA) {
        this.endA = endA;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "  id= ' " + id + '\'' +
                "  name='" + name + '\'' +
                ", nameCountry='" + nameCountry + '\'' +
                '}';
    }
}
