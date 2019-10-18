import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AirportComponent} from "./airport/airport.component";
import {DeleteairportComponent} from "./deleteairport/deleteairport.component";
import {AddflightComponent} from "./addflight/addflight.component";
import {DeleteFlightComponent} from "./delete-flight/delete-flight.component";
import {AllAirportNameCountryComponent} from "./all-airport-name-country/all-airport-name-country.component";
import {AllFlightWithSelectedAirportStartSortedTimeStartComponent} from "./all-flight-with-selected-airport-start-sorted-time-start/all-flight-with-selected-airport-start-sorted-time-start.component";
import {AllFlightWithSelectedAirportEndSortedTimeEndComponent} from "./all-flight-with-selected-airport-end-sorted-time-end/all-flight-with-selected-airport-end-sorted-time-end.component";
import {AllDBSortetAirportStartComponent} from "./all-dbsortet-airport-start/all-dbsortet-airport-start.component";
import {MinConnectBetweenTwoAiportsComponent} from "./min-connect-between-two-aiports/min-connect-between-two-aiports.component";

const routes: Routes = [
  {
    path: 'airport',
    component: AirportComponent
  },
  {
    path: 'deleteairport',
    component: DeleteairportComponent
  },
  {
    path: 'addflight',
    component: AddflightComponent
  },
  {
    path: 'deleteflight',
    component: DeleteFlightComponent
  },
  {
    path: 'allAirportSortNameCountry',
    component: AllAirportNameCountryComponent
  },
  {
    path: 'allFlightWithSelectedAirportStartSortedTimeStart',
    component: AllFlightWithSelectedAirportStartSortedTimeStartComponent
  },
  {
    path: 'allFlightWithSelectedAirportEndSortedTimeEnd',
    component: AllFlightWithSelectedAirportEndSortedTimeEndComponent
  },
  {
    path:'allDB',
    component: AllDBSortetAirportStartComponent
  },
  {
    path: 'minConnectTwoAiports',
    component: MinConnectBetweenTwoAiportsComponent
  },
  {
    path: '',
    redirectTo: '',
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
