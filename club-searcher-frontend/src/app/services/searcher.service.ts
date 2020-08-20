import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const API_SERVER = "http://localhost:8080/api";
@Injectable({
  providedIn: 'root'
})
export class SearcherService {

  constructor(private http: HttpClient) {
  }

  public getLink(clubname) {
    return this.http.get(`${API_SERVER}?clubName=${clubname}`);
  }
}
