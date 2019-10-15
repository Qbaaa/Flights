package com.qbaaa.flights.Repository;

import com.qbaaa.flights.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
