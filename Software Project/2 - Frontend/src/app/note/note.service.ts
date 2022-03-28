import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {INote} from "./INote";

@Injectable({
  providedIn: 'root'
})
export class NoteService {
  private baseURLBase = "http://localhost:8080/api/note/base";
  private baseURLHeart = "http://localhost:8080/api/note/heart";
  private baseURLHead = "http://localhost:8080/api/note/head";

  constructor(private httpClient: HttpClient) {
  }

  getBaseNoteList(): Observable<INote[]> {
    return this.httpClient.get<INote[]>(`${this.baseURLBase}`);
  }

  getHeartNoteList(): Observable<INote[]> {
    return this.httpClient.get<INote[]>(`${this.baseURLHeart}`);
  }

  getHeadNoteList(): Observable<INote[]> {
    return this.httpClient.get<INote[]>(`${this.baseURLHead}`);
  }
}
