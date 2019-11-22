import {Component, Input, OnInit, ViewEncapsulation} from '@angular/core';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class InfoComponent implements OnInit {
  @Input() username: string;

  constructor() { }

  ngOnInit() {
  }

}
