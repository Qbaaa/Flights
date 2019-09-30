package com.qbaaa.flights.Controller;


import com.qbaaa.flights.Model.Airport;
import com.qbaaa.flights.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class QuestionFlightController
{
    @Autowired
    AirportRepository airportRepository;

    @PostMapping("/addAirport")
    public ResponseEntity<?> addAirport(@RequestBody Airport addAirport)
    {
        if(airportRepository.existsByName(addAirport.name) && airportRepository.existsByNameCountry(addAirport.nameCountry))
        {
            return new ResponseEntity<>("Już jest w bazie dane lotnisko" + addAirport.toString() , HttpStatus.BAD_REQUEST);
        }

        airportRepository.save(addAirport);

        return new ResponseEntity<>("Dodano pomyslnie lotnisko" , HttpStatus.OK);
    }
}
