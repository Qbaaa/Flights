import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AirportComponent} from "./airport/airport.component";
import {DeleteairportComponent} from "./deleteairport/deleteairport.component";
import {AddflightComponent} from "./addflight/addflight.component";

const routes: Routes = [
  {
    path: 'airport',
    component: AirportComponent
  },
  {
    path: '',
    redirectTo: '',
    pathMatch: 'full'
  },
  {
    path: 'deleteairport',
    component: DeleteairportComponent
  },
  {
    path: 'addflight',
    component: AddflightComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
