import { Component, OnInit } from '@angular/core';
import {FlightsService} from "../flights.service";
import {Airport} from "../class/airport";
import {Flight} from "../class/flight";

@Component({
  selector: 'app-all-flight-with-selected-airport-start-sorted-time-start',
  templateUrl: './all-flight-with-selected-airport-start-sorted-time-start.component.html',
  styleUrls: ['./all-flight-with-selected-airport-start-sorted-time-start.component.css']
})
export class AllFlightWithSelectedAirportStartSortedTimeStartComponent implements OnInit {

  airports: Airport[];
  message;
  aiportsIsEmpty: boolean;
  messageIs: boolean;
  submited = false;
  selected=0;
  flights: Flight[];

  constructor(private flightService: FlightsService) { }

  ngOnInit()
  {
    this.flightService.getAirport().subscribe( data =>
    {
      this.airports = data;
      this.aiportsIsEmpty = false;
    },
    error =>
    {
      this.message = error.error.message;
      this.aiportsIsEmpty = true;
    });
  }

  onSubmit()
  {
    this.submited = true;

    this.flightService.getAllFlightWithSelectedAirportStartSortedTimeStart(this.selected).subscribe(data =>
    {
      this.messageIs = true;
      this.flights = data;
    },
    error =>
    {
      this.message = error.error.message;
      this.messageIs = false;

    });
  }

}
