import { Component, OnInit } from '@angular/core';
import {Flight} from "../class/flight";
import {FlightsService} from "../flights.service";

@Component({
  selector: 'app-delete-flight',
  templateUrl: './delete-flight.component.html',
  styleUrls: ['./delete-flight.component.css']
})
export class DeleteFlightComponent implements OnInit {

  flights: Flight[];
  flightIsEmpty: boolean;
  message;
  submitted = false;
  deleteFlightIs = false;
  selected = 0;


  constructor(private flightService: FlightsService) { }

  ngOnInit()
  {
    this.flightService.getFlight().subscribe( data =>
    {
      this.flights = data;
      this.flightIsEmpty = false;
    },
    error =>
    {
     this.message = error.error.message;
     this.flightIsEmpty = true;
    });

  }


  deleteFlight()
  {
    this.submitted = true;

    this.flightService.deleteFlight(this.selected).subscribe(
      data =>
      {
        this.message = data.message;
        this.deleteFlightIs = true;
      },
      error =>
      {
        this.message = error.error.message;
        this.deleteFlightIs = false;
      });
  }

}
