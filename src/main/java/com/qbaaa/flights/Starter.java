package com.qbaaa.flights;

import com.qbaaa.flights.Model.Airport;
import com.qbaaa.flights.Model.FlightPersonal;
import com.qbaaa.flights.Repository.AirportRepository;
import com.qbaaa.flights.Repository.FlightPersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class Starter implements CommandLineRunner
{
    @Autowired
    AirportRepository airportRepository;

    @Autowired
    FlightPersonalRepository flightPersonalRepository;

    @Override
    public void run(String... args) throws Exception {

        airportRepository.save(new Airport("Warszawa","Polska"));
        airportRepository.save(new Airport("Gdansk","Polska"));
        airportRepository.save(new Airport("Barcelona","Hiszpania"));
        airportRepository.save(new Airport("Paryz","Francja"));
        airportRepository.save(new Airport("Londyn","Anglia"));
        airportRepository.save(new Airport("Los Angeles","USA"));
        airportRepository.save(new Airport("Rzym","Wlochy"));
        airportRepository.save(new Airport("Porto","Portugalia"));
        airportRepository.save(new Airport("Glasgow","Szkocja"));
        airportRepository.save(new Airport("Praga","Czechy"));
        airportRepository.save(new Airport("Dortmund","Niemcy"));
        airportRepository.save(new Airport("Mediolan","Wlochy"));
        airportRepository.save(new Airport("Kijów","Ukraina"));
        airportRepository.save(new Airport("Moskwa","Rosja"));

        Airport s = new Airport("Chicago","USA");
        Airport e = new Airport("Rosario","Argentyna");
        airportRepository.save(s);
        airportRepository.save(e);

        flightPersonalRepository.save(new FlightPersonal(s, e, LocalTime.now(), new Long("22"), 22, 12));

    }
}
