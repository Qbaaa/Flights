import { Component, OnInit } from '@angular/core';
import {Airport} from "../class/airport";
import {FlightsService} from "../flights.service";
import {MinConnectBetweenTwoAirports} from "../class/MinConnectBetweenTwoAirports";

@Component({
  selector: 'app-min-connect-between-two-aiports',
  templateUrl: './min-connect-between-two-aiports.component.html',
  styleUrls: ['./min-connect-between-two-aiports.component.css']
})
export class MinConnectBetweenTwoAiportsComponent implements OnInit {

  airports: Airport[];
  message;
  aiportsIsEmpty: boolean;
  submited;
  messageIs;
  id_start=0;
  id_end=0;
  information: MinConnectBetweenTwoAirports;

  constructor(private flightService: FlightsService)
  { }

  ngOnInit() {
    this.flightService.getAirport().subscribe( data =>
      {
        this.airports = data;
        this.aiportsIsEmpty = false;

        if (this.airports.length < 2)
        {
          this.message = "Mala liosc lotnisk";
          this.aiportsIsEmpty = true;
        }
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

    this.flightService.getMinConnectTwoAiports(this.id_start, this.id_end).subscribe(data =>
      {
        this.messageIs = true;
        this.information = data;
      },
      error =>
      {
        this.message = error.error.message;
        this.messageIs = false;

      });
  }

}
