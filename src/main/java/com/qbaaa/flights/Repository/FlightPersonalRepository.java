package com.qbaaa.flights.Repository;

import com.qbaaa.flights.Model.FlightPersonal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightPersonalRepository extends JpaRepository<FlightPersonal, Long> {
}
