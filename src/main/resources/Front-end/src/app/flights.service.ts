import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Addairport} from "./class/addairport";
import {ResponseMessage} from "./class/ResponseMessage";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class FlightsService {

  private airportUrl = 'http://localhost:8080/addAirport';

  constructor(private http: HttpClient) { }

  addAirport(addAirport: Addairport) : Observable<ResponseMessage>
  {
   return this.http.post<ResponseMessage>(this.airportUrl, addAirport , httpOptions);
  }

}
