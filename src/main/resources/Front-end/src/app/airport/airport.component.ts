import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import {Addairport} from "../class/addairport";
import {FlightsService} from "../flights.service"

@Component({
  selector: 'app-airport',
  templateUrl: './airport.component.html',
  styleUrls: ['./airport.component.css']
})
export class AirportComponent implements OnInit {

  airportForm: FormGroup;
  submitted = false;
  addAirport: Addairport;
  message: any;
  messageIs: boolean;

  constructor(private fb: FormBuilder, private flightService: FlightsService) { }

  ngOnInit() {
    this.airportForm = this.fb.group({
      name: ['', Validators.required],
      nameCountry: ['',Validators.required]
    });
  }

  get f() { return this.airportForm.controls; }

  onSubmit()
  {
    this.submitted = true;

    if (this.airportForm.invalid) {
      return;
    }

    this.addAirport = this.airportForm.value;

    this.flightService.addAirport(this.addAirport).subscribe(
      data =>{
        this.messageIs = true;
        this.message = data.message;
        window.alert(this.message);
      },
      error => {
        this.messageIs = false;
        this.message = error.error.message;
      }
    );

  }

}
