import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AirportComponent } from './airport/airport.component';
import { DeleteairportComponent } from './deleteairport/deleteairport.component';
import { AddflightComponent } from './addflight/addflight.component';
import { DeleteFlightComponent } from './delete-flight/delete-flight.component';
import { AllAirportNameCountryComponent } from './all-airport-name-country/all-airport-name-country.component';
import { AllFlightWithSelectedAirportStartSortedTimeStartComponent } from './all-flight-with-selected-airport-start-sorted-time-start/all-flight-with-selected-airport-start-sorted-time-start.component';
import { AllFlightWithSelectedAirportEndSortedTimeEndComponent } from './all-flight-with-selected-airport-end-sorted-time-end/all-flight-with-selected-airport-end-sorted-time-end.component';
import { AllDBSortetAirportStartComponent } from './all-dbsortet-airport-start/all-dbsortet-airport-start.component';

@NgModule({
  declarations: [
    AppComponent,
    AirportComponent,
    DeleteairportComponent,
    AddflightComponent,
    DeleteFlightComponent,
    AllAirportNameCountryComponent,
    AllFlightWithSelectedAirportStartSortedTimeStartComponent,
    AllFlightWithSelectedAirportEndSortedTimeEndComponent,
    AllDBSortetAirportStartComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
