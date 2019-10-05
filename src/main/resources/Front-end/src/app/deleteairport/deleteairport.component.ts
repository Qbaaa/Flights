import { Component, OnInit } from '@angular/core';
import {Airport} from "../class/airport";
import {FlightsService} from "../flights.service";

@Component({
  selector: 'app-deleteairport',
  templateUrl: './deleteairport.component.html',
  styleUrls: ['./deleteairport.component.css']
})
export class DeleteairportComponent implements OnInit {

  selected = 0;
  airports: Airport[];
  deleteAirportIs = false;
  submitted = false;
  message: string;

  constructor(private flightService: FlightsService) { }

  ngOnInit() {

    this.flightService.getAirport().subscribe(data =>
      {
        this.airports = data;
      }
    );

  }


  deleteAirport() {

    this.submitted = true;

    this.flightService.deleteAirport(this.selected).subscribe(
      data =>
      {
        this.deleteAirportIs = true;
        this.message = data.message;
      },
      error => {
        this.message = error.error.message;
      }
    );
  }

}
