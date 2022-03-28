import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Observable} from 'rxjs';
import {ICountry} from './ICountry';

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  private baseURL = "http://localhost:8080/api/country";

  constructor(private httpClient: HttpClient) {
  }

  getCountryList(): Observable<ICountry[]> {
    return this.httpClient.get<ICountry[]>(`${this.baseURL}`);
  }
}
