import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Airport} from "./class/airport";
import {ResponseMessage} from "./class/ResponseMessage";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class FlightsService {

  private airportUrlAddAirport = 'http://localhost:8080/addAirport';
  private airportUrlDeleteAirport = 'http://localhost:8080/deleteAirport';
  private airportUrlGetAirport = 'http://localhost:8080/getAirport';
  private airportUrlAddFlight = 'http://localhost:8080/addFlight';

  constructor(private http: HttpClient) { }

  addAirport(addAirport: Airport) : Observable<ResponseMessage>
  {
   return this.http.post<ResponseMessage>(this.airportUrlAddAirport, addAirport , httpOptions);
  }

  deleteAirport(id: number) : Observable<ResponseMessage>
  {
    return this.http.delete<ResponseMessage>(`${this.airportUrlDeleteAirport}/${id}`, httpOptions);
  }

  getAirport() : Observable<Airport[]>
  {
    return this.http.get<Airport[]>(this.airportUrlGetAirport, httpOptions);
  }

  addFlight(addFlight: any) : Observable<ResponseMessage>
  {
    return this.http.post<ResponseMessage>(this.airportUrlAddFlight, addFlight, httpOptions);
  }

}
