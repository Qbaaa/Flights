import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Airport} from "./class/airport";
import {ResponseMessage} from "./class/ResponseMessage";
import {Flight} from "./class/flight";
import {MinConnectBetweenTwoAirports} from "./class/MinConnectBetweenTwoAirports";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class FlightsService {

  private UrlAddAirport = 'http://localhost:8080/addAirport';
  private UrlDeleteAirport = 'http://localhost:8080/deleteAirport';
  private UrlGetAirport = 'http://localhost:8080/getAirport';
  private UrlAddFlight = 'http://localhost:8080/addFlight';
  private UrlDeleteFlight = 'http://localhost:8080/deleteFlight';
  private UrlGetFlight = 'http://localhost:8080/getFlight';
  private UrlGetAirportSortedNameCountry = 'http://localhost:8080/getAirportSortedNameCountry';
  private UrlGetAllFlightWithSelectedAirportStartSortedTimeStart = 'http://localhost:8080/getAllFlightWithSelectedAirportStartSortedTimeStart';
  private UrlGetAllFlightWithSelectedAirportEndSortedTimeEnd = 'http://localhost:8080/getAllFlightWithSelectedAirportEndSortedTimeEnd';
  private UrlGetAllDB = 'http://localhost:8080/getAllDB';
  private UrlGetMinConnectAiports = 'http://localhost:8080/getMinConnectBetweenTwoAiports';

  constructor(private http: HttpClient) { }

  addAirport(addAirport: Airport) : Observable<ResponseMessage>
  {
   return this.http.post<ResponseMessage>(this.UrlAddAirport, addAirport , httpOptions);
  }

  deleteAirport(id: number) : Observable<ResponseMessage>
  {
    return this.http.delete<ResponseMessage>(`${this.UrlDeleteAirport}/${id}`, httpOptions);
  }

  getAirport() : Observable<Airport[]>
  {
    return this.http.get<Airport[]>(this.UrlGetAirport, httpOptions);
  }

  addFlight(addFlight: any) : Observable<ResponseMessage>
  {
    return this.http.post<ResponseMessage>(this.UrlAddFlight, addFlight, httpOptions);
  }

  deleteFlight(id: number) : Observable<ResponseMessage>
  {
    return this.http.delete<ResponseMessage>(`${this.UrlDeleteFlight}/${id}`, httpOptions);
  }

  getFlight(): Observable<Flight[]>
  {
    return this.http.get<Flight[]>(this.UrlGetFlight,httpOptions);
  }

  getAiportSortedNameCountry(): Observable<Airport[]>
  {
    return this.http.get<Airport[]>(this.UrlGetAirportSortedNameCountry, httpOptions);
  }

  getAllFlightWithSelectedAirportStartSortedTimeStart(id: number) : Observable<Flight[]>
  {
    return this.http.get<Flight[]>(`${this.UrlGetAllFlightWithSelectedAirportStartSortedTimeStart}/${id}` , httpOptions);
  }

  getAllFlightWithSelectedAirportEndSortedTimeEnd(id: number) : Observable<Flight[]>
  {
    return this.http.get<Flight[]>(`${this.UrlGetAllFlightWithSelectedAirportEndSortedTimeEnd}/${id}` , httpOptions);
  }

  getAllDB() : Observable<Flight[]>
  {
    return this.http.get<Flight[]>(this.UrlGetAllDB, httpOptions);
  }

  getMinConnectTwoAiports(id_start:number, id_end:number):Observable<MinConnectBetweenTwoAirports>
  {
    return this.http.get<MinConnectBetweenTwoAirports>(`${this.UrlGetMinConnectAiports}/${id_start}/${id_end}`, httpOptions);
  }
}
