package com.qbaaa.flights.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qbaaa.flights.Model.Airport;


public interface AirportRepository extends JpaRepository<Airport, Long> {

    boolean existsByName(String name);
    boolean existsByNameCountry(String nameCountry);

}
