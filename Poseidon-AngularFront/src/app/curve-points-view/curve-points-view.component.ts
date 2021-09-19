import { Component, OnInit } from '@angular/core';

export interface CurvePointObject {
  id: number;
  curvePointId: number;
  term: number;
  value: number;
  action: any;
}

const ELEMENT_DATA: CurvePointObject[] = [
  {id: 1, curvePointId: 12, term: 14, value: 10.0, action:''},
  {id: 2, curvePointId: 12, term: 14, value: 10.0, action:''},
  {id: 3, curvePointId: 12, term: 14, value: 10.0, action:''},
  {id: 4, curvePointId: 12, term: 14, value: 10.0, action:''},
  {id: 5, curvePointId: 12, term: 14, value: 10.0, action:''},
  {id: 6, curvePointId: 12, term: 14, value: 10.0, action:''},
];

@Component({
  selector: 'app-curve-points-view',
  templateUrl: './curve-points-view.component.html',
  styleUrls: ['./curve-points-view.component.css']
})
export class CurvePointsViewComponent implements OnInit {

  displayedColumns: string[] = ['id', 'curvePointId', 'term', 'value', 'action'];
  dataSource = ELEMENT_DATA;

  constructor() { }

  ngOnInit(): void {
  }

}
