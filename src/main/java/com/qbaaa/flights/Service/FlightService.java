package com.qbaaa.flights.Service;

import com.qbaaa.flights.Model.Airport;
import com.qbaaa.flights.Model.Flight;
import com.qbaaa.flights.Model.FlightPersonal;
import com.qbaaa.flights.Model.TypeFlight;
import com.qbaaa.flights.Repository.AirportRepository;
import com.qbaaa.flights.Response.MinConnectBetweenTwoAirportsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService
{
    @Autowired
    AirportRepository airportRepository;

    public MinConnectBetweenTwoAirportsResponse minChangeBetweenAiports(Long id_start, Long id_end)
    {
        Airport airport = airportRepository.findById(id_start).orElseThrow(() -> new RuntimeException("Blad brak lotniska!"));
        List<List<FlightPersonal>> listtFoundConnectFlight = new ArrayList<>();
        List<Long> visited = new ArrayList<>();
        visited.add(id_start);

        search(airport.getStartA(), id_end, listtFoundConnectFlight, visited, new ArrayList<>());

        int index = -1;
        int min = Integer.MAX_VALUE;
        int amount = 0;

        for (List<FlightPersonal> ele: listtFoundConnectFlight)
        {
            if (ele.size() < min)
            {
                min = ele.size();
                index = amount;
            }
            amount++;
        }

        if(listtFoundConnectFlight.isEmpty())
        {
            return null;
        }
        else
            return new MinConnectBetweenTwoAirportsResponse(listtFoundConnectFlight.get(index));
    }

    public void search(List<Flight> listFlightWithAiport, Long id_end, List<List<FlightPersonal>> listFoundConnectFlight, List<Long> visited, List<FlightPersonal> foundConnectFlight )
    {
        for (Flight ele: listFlightWithAiport)
        {
            if(ele.getType().equals(TypeFlight.personal))
            {
                boolean loop = true;

                for (Long number :visited)
                {
                    if (ele.getEnd().getId().equals(number))
                        loop = false;
                }

                if (loop)
                {
                    foundConnectFlight.add((FlightPersonal)ele);

                    if (ele.getEnd().getId().equals(id_end))
                    {
                        listFoundConnectFlight.add(new ArrayList<>(foundConnectFlight));
                        foundConnectFlight.remove(foundConnectFlight.size()-1);
                        continue;
                    }

                    visited.add(ele.getEnd().getId());
                    search(ele.getEnd().getStartA(),id_end, listFoundConnectFlight,visited, foundConnectFlight);
                    visited.remove(visited.size()-1);
                    foundConnectFlight.remove(foundConnectFlight.size()-1);
                }
            }
        }
    }



}
