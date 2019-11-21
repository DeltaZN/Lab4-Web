import { Injectable } from '@angular/core';
import { Point} from "../model/model.point";
import {Http} from "@angular/http";

@Injectable()
export class HistoryService {

  constructor(public http: Http) { }

  public getPoints(): Point[] {
    // TODO: getting point fby api
    return [
      new Point(3,5,7,true),
      new Point(3,5,7,true),
      new Point(3,5,7,true)
    ];
  }
}
