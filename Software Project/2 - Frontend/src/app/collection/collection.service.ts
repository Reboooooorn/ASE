import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ICollection} from "./ICollection";

@Injectable({
  providedIn: 'root'
})
export class CollectionService {
  private baseURL = "http://localhost:8080/api/collection";
  private createURL = "http://localhost:8080/api/uc/2";
  private addURL = "http://localhost:8080/api/uc/5a";

  constructor(private httpClient: HttpClient) {
  }

  getCollections(): Observable<ICollection[]> {
    return this.httpClient.get<ICollection[]>(`${this.baseURL}`);
  }

  createCollection(name: string): Observable<any> {
    return this.httpClient.post(this.createURL + "?collectionName=" + name, "")
  }

  addPerfumeToCollection(perfumeID: number, collectionID: number) {
    return this.httpClient.post(this.addURL + "?perfumeID=" + perfumeID + "&collectionID=" + collectionID, "")
  }
}
