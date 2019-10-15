import { Component, OnInit } from '@angular/core';
import {Airport} from "../class/airport";
import {FlightsService} from "../flights.service";
import {Flight} from "../class/flight";

@Component({
  selector: 'app-all-dbsortet-airport-start',
  templateUrl: './all-dbsortet-airport-start.component.html',
  styleUrls: ['./all-dbsortet-airport-start.component.css']
})
export class AllDBSortetAirportStartComponent implements OnInit {

  flights: Flight[];
  listAirportIsEmpty:boolean;
  message;
  airports: Airport[];

  constructor(private flightService: FlightsService) { }

  ngOnInit()
  {
    this.flightService.getAiportSortedNameCountry().subscribe( data =>
      {
        this.airports = data;
      });

    this.flightService.getAllDB().subscribe(
      data =>
      {
        this.listAirportIsEmpty = false;
        this.flights = data;
      },
      error =>
      {
        this.listAirportIsEmpty = true;
        this.message=error.error.message;
      });
  }

}
