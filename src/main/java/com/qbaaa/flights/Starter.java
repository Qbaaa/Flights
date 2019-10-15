package com.qbaaa.flights;

import com.qbaaa.flights.Model.Airport;
import com.qbaaa.flights.Model.Flight;
import com.qbaaa.flights.Model.FlightCargo;
import com.qbaaa.flights.Model.FlightPersonal;
import com.qbaaa.flights.Repository.AirportRepository;
import com.qbaaa.flights.Repository.FlightCargoRepository;
import com.qbaaa.flights.Repository.FlightPersonalRepository;
import com.qbaaa.flights.Repository.FlightRepository;
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

    @Autowired
    FlightCargoRepository flightCargoRepository;

    @Autowired
    FlightRepository flightRepository;

    @Override
    public void run(String... args) throws Exception {

        Airport a1 = airportRepository.save(new Airport("Warszawa","Polska"));
        Airport a2 = airportRepository.save(new Airport("Gdansk","Polska"));
        Airport a3 = airportRepository.save(new Airport("Barcelona","Hiszpania"));
        Airport a4 = airportRepository.save(new Airport("Paryz","Francja"));
        Airport a5 = airportRepository.save(new Airport("Londyn","Anglia"));
        Airport a6 = airportRepository.save(new Airport("Los Angeles","USA"));
        Airport a7 = airportRepository.save(new Airport("Rzym","Wlochy"));
        Airport a8 = airportRepository.save(new Airport("Porto","Portugalia"));
        Airport a9 = airportRepository.save(new Airport("Glasgow","Szkocja"));
        Airport a10= airportRepository.save(new Airport("Praga","Czechy"));
        Airport a11=airportRepository.save(new Airport("Dortmund","Niemcy"));
        Airport a12=airportRepository.save(new Airport("Mediolan","Wlochy"));
        Airport a13=airportRepository.save(new Airport("Kijów","Ukraina"));
        Airport a14=airportRepository.save(new Airport("Moskwa","Rosja"));
        Airport a15=airportRepository.save(new Airport("Chicago","USA"));
        Airport a16= airportRepository.save(new Airport("Rosario","Argentyna"));

        flightPersonalRepository.save(new FlightPersonal(a15, a16, LocalTime.now(), new Long("210"), 222, 12));
        flightCargoRepository.save(new FlightCargo(a1,a2,LocalTime.now().plusHours(10),new Long("25"), 150, 15));
        flightPersonalRepository.save(new FlightPersonal(a3,a5,LocalTime.of(15,45),new Long("60"), 150, 15));
        flightPersonalRepository.save(new FlightPersonal(a15,a4,LocalTime.of(16,45),new Long("70"), 160, 20));

        System.out.println(airportRepository.findById(new Long("2")));

    }
}
