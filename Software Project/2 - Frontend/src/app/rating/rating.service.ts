import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {IRating} from "./IRating";

@Injectable({
  providedIn: 'root'
})
export class RatingService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  private baseURL = "http://localhost:8080/api/rating";
  private createURL = "http://localhost:8080/api/uc/4";

  constructor(private httpClient: HttpClient) {
  }

  getRatings(): Observable<IRating[]> {
    return this.httpClient.get<IRating[]>(`${this.baseURL}`);
  }

  createRating(iRating: IRating): Observable<any> {
    return this.httpClient.post(this.createURL, JSON.stringify(iRating), this.httpOptions)
  }
}
