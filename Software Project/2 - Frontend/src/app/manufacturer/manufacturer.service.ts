import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http'
import {Observable} from 'rxjs';
import {IManufacturer} from './IManufacturer';

@Injectable({
  providedIn: 'root'
})
export class ManufacturerService {
  private baseURL = "http://localhost:8080/api/manufacturer";

  constructor(private httpClient: HttpClient) {
  }

  getManufacturerList(): Observable<IManufacturer[]> {
    return this.httpClient.get<IManufacturer[]>(`${this.baseURL}`);
  }
}
