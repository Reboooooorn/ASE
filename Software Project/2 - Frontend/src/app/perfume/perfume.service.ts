import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {IPerfume} from "./IPerfume";

@Injectable({
  providedIn: 'root'
})
export class PerfumeService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  private baseURL = "http://localhost:8080/api/perfume";
  private createURL = "http://localhost:8080/api/uc/1";

  constructor(private httpClient: HttpClient) {
  }

  getPerfumes(): Observable<IPerfume[]> {
    return this.httpClient.get<IPerfume[]>(`${this.baseURL}`);
  }

  createPerfume(iPerfume: IPerfume): Observable<any> {
    return this.httpClient.post(this.createURL, JSON.stringify(iPerfume), this.httpOptions)
  }

}
