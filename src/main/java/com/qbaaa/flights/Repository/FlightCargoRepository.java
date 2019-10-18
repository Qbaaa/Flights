package com.qbaaa.flights.Repository;

import com.qbaaa.flights.Model.FlightCargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightCargoRepository extends JpaRepository<FlightCargo, Float> {
}
