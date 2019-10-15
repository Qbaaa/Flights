package com.qbaaa.flights.Controller;


import com.qbaaa.flights.Model.*;
import com.qbaaa.flights.Repository.AirportRepository;
import com.qbaaa.flights.Repository.FlightCargoRepository;
import com.qbaaa.flights.Repository.FlightPersonalRepository;
import com.qbaaa.flights.Repository.FlightRepository;
import com.qbaaa.flights.Request.FlightForm;
import com.qbaaa.flights.Response.MessageResponse;
import com.qbaaa.flights.Service.AirportNameCountryComparator;
import com.qbaaa.flights.Service.FlightTimeStartComparator;
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

    @Autowired
    FlightPersonalRepository flightPersonalRepository;

    @Autowired
    FlightCargoRepository flightCargoRepository;

    @Autowired
    FlightRepository flightRepository;

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
        List<Airport> listAirport = airportRepository.findAll();

        if(listAirport.isEmpty())
            return new ResponseEntity<>(new MessageResponse("Brak lotnisk w bazie"),HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(listAirport, HttpStatus.OK);

    }

    @DeleteMapping("/deleteAirport/{id}")
    public ResponseEntity<?> deleteAirport(@PathVariable("id") Long id)
    {
        if (id == 0)
            return new ResponseEntity<>(new MessageResponse("Nie wybrano żadnego lotniska!") ,HttpStatus.BAD_REQUEST);

        Airport delAirport = airportRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma lotniska o zadanym id!"));

        if (!delAirport.getEndA().isEmpty() || !delAirport.getStartA().isEmpty())
            return new ResponseEntity<>(new MessageResponse("NIE mozna usunąc lotniska, poniewaz jest powiazany z lotam."),HttpStatus.BAD_REQUEST);

        airportRepository.delete(delAirport);

        return new ResponseEntity<>(new MessageResponse("Usuniecie lotniska przebiegło pomyślnie."),HttpStatus.OK);
    }

    @PostMapping("/addFlight")
    public ResponseEntity<?> addFlight(@RequestBody FlightForm form)
    {
        Airport start = airportRepository.findById(form.getStartAirport()).orElseThrow(() -> new RuntimeException("Blad lotniska startowego !"));
        Airport end = airportRepository.findById(form.getEndAirport()).orElseThrow(() -> new RuntimeException("Blad lotniska koncowego !"));

        if (form.getType().equals("personal"))
        {
            flightPersonalRepository.save(new FlightPersonal(start, end, form.getTimeStart(), form.getDurationTimeMinutes(), form.getPriceForOnePlace(), form.getMaxWightBaggageForOnePerson()));
        }
        else
        {
            flightCargoRepository.save(new FlightCargo(start, end, form.getTimeStart(), form.getDurationTimeMinutes(), form.getFeeConst(), form.getFeeForKiloPack()));
        }

        return new ResponseEntity<>(new MessageResponse("Dodano pomyslnie lot."),HttpStatus.OK);
    }

    @GetMapping("/getFlight")
    public ResponseEntity<?> getFlight()
    {
        List<Flight> list = flightRepository.findAll();

        if (list.isEmpty())
            return new ResponseEntity<>(new MessageResponse("Brak lotow w bazie !!!"), HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @DeleteMapping("/deleteFlight/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable Long id)
    {
        if (id == 0)
            return new ResponseEntity<>(new MessageResponse("Nie wybrano żadnego lotu!!!") ,HttpStatus.BAD_REQUEST);

        Flight del = flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma lotu o zadanym id!"));

        flightRepository.delete(del);

        return new ResponseEntity<>(new MessageResponse("Usuniecie lotu przebiegło pomyślnie."),HttpStatus.OK);
    }

    @GetMapping("/getAirportSortedNameCountry")
    public ResponseEntity<?> getAiportSortedNameCountry()
    {
        List<Airport> list = airportRepository.findAll();

        if(list.isEmpty())
            return new ResponseEntity<>(new MessageResponse("Brak Lotnisk do wyswietlenia !!!"), HttpStatus.BAD_REQUEST);

        list.sort(new AirportNameCountryComparator());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/getAllFlightWithSelectedAirportStartSortedTimeStart/{id}")
    public ResponseEntity<?> getAllFlightWithSelectedAirportStartSortedTimeStart(@PathVariable Long id)
    {
        if (id == 0)
            return new ResponseEntity<>(new MessageResponse("Nie wybrano żadnego lotniska!!!") ,HttpStatus.BAD_REQUEST);

        Airport start = airportRepository.findById(id).orElseThrow(() -> new RuntimeException("Blad brak lotniska!"));

        if (start.getStartA().isEmpty())
            return new ResponseEntity<>(new MessageResponse("BRAK lotów z podanego lotniska!!!") ,HttpStatus.BAD_REQUEST);

        List<Flight> list = start.getStartA();
        list.sort(new FlightTimeStartComparator());

        return new ResponseEntity<>(list ,HttpStatus.OK);
    }

}
