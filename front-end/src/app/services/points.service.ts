import { Injectable } from '@angular/core';
import { Point} from "../model/model.point";
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AppComponent} from "../app.component";
import {Observable} from "rxjs";
import { map } from 'rxjs/operators';

@Injectable()
export class PointsService {

  constructor(public http: HttpClient) { }

  private getHeaders(): HttpHeaders {
    let base64Credential: string = localStorage.getItem('userHash');

    let headers = new HttpHeaders().set("Authorization", "Basic " + base64Credential);

    headers.append('Accept', 'application/json');
    headers.append('Content-Type', 'application/json');

    return headers;
  }

  public getPoints(): Observable<any> {

    return this.http.get(AppComponent.API_URL+'/points',{ headers: this.getHeaders()});
  }

  public addPoint(point: Point) {
    const body = {x: point.x, y: point.y, r: point.r};
    this.http.post(AppComponent.API_URL+'/points', body, { headers: this.getHeaders()}).subscribe(data => console.log(data));
  }
}
