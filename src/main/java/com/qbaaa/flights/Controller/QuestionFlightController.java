package com.qbaaa.flights.Controller;


import com.qbaaa.flights.Model.Airport;
import com.qbaaa.flights.Repository.AirportRepository;
import com.qbaaa.flights.Response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class QuestionFlightController
{
    @Autowired
    AirportRepository airportRepository;

    @PostMapping("/addAirport")
    public ResponseEntity<?> addAirport(@RequestBody Airport addAirport)
    {
        if(airportRepository.existsByName(addAirport.getName()) && airportRepository.existsByNameCountry(addAirport.getNameCountry()))
        {
            return new ResponseEntity<>(new MessageResponse("Już jest w bazie dane lotnisko " + addAirport.toString()) , HttpStatus.BAD_REQUEST);
        }

        airportRepository.save(addAirport);

        return new ResponseEntity<>( new MessageResponse("Dodano pomyslnie lotnisko ") , HttpStatus.OK);
    }

    @GetMapping("/getAirport")
    public ResponseEntity<?> getAirport()
    {
        List listAirport = airportRepository.findAll();

        if(listAirport.isEmpty())
            return new ResponseEntity<>(new MessageResponse("Barak lotnisk w bazie"),HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(listAirport, HttpStatus.OK);

    }

    @DeleteMapping("/deleteAirport/{id}")
    public ResponseEntity<?> deleteAirport(@PathVariable("id") Long id)
    {
        if (id == 0)
        {
            return new ResponseEntity<>(new MessageResponse("Nie wybrano żadnego lotniska!") ,HttpStatus.BAD_REQUEST);
        }

        Airport delAirport = airportRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma lotniska o zadanym id!"));

        airportRepository.delete(delAirport);

        return new ResponseEntity<>(new MessageResponse("Usuniecie lotniska przebiegło pomyślnie."),HttpStatus.OK);
    }

}
