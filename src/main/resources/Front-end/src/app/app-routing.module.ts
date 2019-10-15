import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AirportComponent} from "./airport/airport.component";
import {DeleteairportComponent} from "./deleteairport/deleteairport.component";
import {AddflightComponent} from "./addflight/addflight.component";
import {DeleteFlightComponent} from "./delete-flight/delete-flight.component";

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
