import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';

@Component({
  selector: 'app-airport',
  templateUrl: './airport.component.html',
  styleUrls: ['./airport.component.css']
})
export class AirportComponent implements OnInit {

  airportForm: FormGroup;
  submitted = false;

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.airportForm = this.fb.group({
      nameAirport: ['', Validators.required],
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

    document.write("Wiww");

  }

}
