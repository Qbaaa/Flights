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

  private airportUrl = 'http://localhost:8080/addAirport';
  private airportUrl2 = 'http://localhost:8080/deleteAirport';
  private airportUrl3 = 'http://localhost:8080/getAirport';

  constructor(private http: HttpClient) { }

  addAirport(addAirport: Airport) : Observable<ResponseMessage>
  {
   return this.http.post<ResponseMessage>(this.airportUrl, addAirport , httpOptions);
  }

  deleteAirport(id: number) : Observable<ResponseMessage>
  {
    return this.http.delete<ResponseMessage>(`${this.airportUrl2}/${id}`, httpOptions);
  }

  getAirport() : Observable<Airport[]>
  {
    return this.http.get<Airport[]>(this.airportUrl3, httpOptions);
  }

}
