import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AirportComponent } from './airport/airport.component';
import { DeleteairportComponent } from './deleteairport/deleteairport.component';
import { AddflightComponent } from './addflight/addflight.component';

@NgModule({
  declarations: [
    AppComponent,
    AirportComponent,
    DeleteairportComponent,
    AddflightComponent,
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
