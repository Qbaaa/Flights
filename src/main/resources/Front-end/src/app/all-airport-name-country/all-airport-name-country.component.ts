import { Component, OnInit } from '@angular/core';
import {FlightsService} from "../flights.service";
import {Airport} from "../class/airport";

@Component({
  selector: 'app-all-airport-name-country',
  templateUrl: './all-airport-name-country.component.html',
  styleUrls: ['./all-airport-name-country.component.css']
})
export class AllAirportNameCountryComponent implements OnInit {

  airports: Airport[];
  listAirportIsEmpty:boolean;
  message;

  constructor(private flightService: FlightsService) { }

  ngOnInit()
  {
    this.flightService.getAiportSortedNameCountry().subscribe(
      data =>
      {
        this.listAirportIsEmpty = false;
        this.airports = data;
      },
      error =>
      {
        this.listAirportIsEmpty = true;
        this.message=error.error.message;
      });
  }

}
