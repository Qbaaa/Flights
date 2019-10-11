import { Component, OnInit } from '@angular/core';
import {FlightsService} from "../flights.service";
import {Airport} from "../class/airport";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-addflight',
  templateUrl: './addflight.component.html',
  styleUrls: ['./addflight.component.css']
})
export class AddflightComponent implements OnInit {

  airports: Airport[];
  dynamicForm: FormGroup;
  submitted = false;
  messageIs : boolean;
  message;

  constructor(private flightService:  FlightsService, private fb: FormBuilder) { }

  ngOnInit() {

    this.dynamicForm = this.fb.group({
      selectedType: ['',Validators.required],
      flightForm: new FormArray([])
    });

    this.flightService.getAirport().subscribe(
      data =>
      {
        this.airports = data;
      });
  }

  get f() { return this.dynamicForm.controls; }
  get formFlight() {
    return this.dynamicForm.get('flightForm') as FormArray;
  }

  onChangeType(e)
  {
    this.formFlight.clear();

    const selectedType  = e;

    if (selectedType == 'personal') {

      this.formFlight.push(this.fb.group({
        type: ['personal'],
          startAirport: ['',Validators.required],
          endAirport: ['', Validators.required],
          timeStart: ['', Validators.required],
          durationTimeMinutes: ['',Validators.required],
          priceForOnePlace: ['',Validators.required],
          maxWightBaggageForOnePerson: ['',Validators.required]
      }));
    }
    else if (selectedType == "cargo") {

      this.formFlight.push(this.fb.group({
        type: ['cargo'],
        startAirport: ['', Validators.required],
        endAirport: ['', Validators.required],
        timeStart: ['', Validators.required],
        durationTimeMinutes: ['', Validators.required],
        feeConst: ['', Validators.required],
        feeForKiloPack: ['', Validators.required]
      }));
    }
  }

  onSubmit()
  {
    this.submitted = true;

    if (this.dynamicForm.invalid)
      return;

    if (this.formFlight.at(0).value.startAirport === this.formFlight.at(0).value.endAirport)
    {
      this.messageIs = false;
      this.message = "Lotnisko początkowe i końcowe muszą być różne !!!";
      return;
    }

    this.flightService.addFlight(this.formFlight.at(0).value).subscribe(
      data =>{
        this.messageIs = true;
        this.message = data.message;
      },
      error => {
        this.messageIs = false;
        this.message = error.error.message;
      }
    );

  }

}
