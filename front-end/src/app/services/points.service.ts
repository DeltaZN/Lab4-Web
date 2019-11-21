import { Injectable } from '@angular/core';
import { Point} from "../model/model.point";
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AppComponent} from "../app.component";

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

  public getPoints(): Point[] {
    this.http.get(AppComponent.API_URL+'/points',{ headers: this.getHeaders()}).pipe(data => {
      let pointsList = data;
      return pointsList.map(function(point:any) {
        return {x: point.x, y: point.y, r: point.r, result: point.inArea};
      });
    });

    return [
      new Point(3,5,7,true),
      new Point(3,5,7,true),
      new Point(3,5,7,true)
    ];
  }

  public addPoint(point: Point) {
    const body = {x: point.x, y: point.y, r: point.r};
    this.http.post(AppComponent.API_URL+'/points', body, { headers: this.getHeaders()}).subscribe(data => console.log(data));
  }
}
