import { Component, OnInit } from '@angular/core';
import {Airport} from "../class/airport";
import {Flight} from "../class/flight";
import {FlightsService} from "../flights.service";

@Component({
  selector: 'app-all-flight-with-selected-airport-end-sorted-time-end',
  templateUrl: './all-flight-with-selected-airport-end-sorted-time-end.component.html',
  styleUrls: ['./all-flight-with-selected-airport-end-sorted-time-end.component.css']
})
export class AllFlightWithSelectedAirportEndSortedTimeEndComponent implements OnInit {

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

    this.flightService.getAllFlightWithSelectedAirportEndSortedTimeEnd(this.selected).subscribe(data =>
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
