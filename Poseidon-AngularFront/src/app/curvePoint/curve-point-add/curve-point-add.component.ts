import { Component, OnInit } from '@angular/core';
import { CurvePoint } from '../curve-point';
import { CurvePointService } from '../curve-point.service';

@Component({
  selector: 'app-curve-point-add',
  templateUrl: './curve-point-add.component.html',
  styleUrls: ['./curve-point-add.component.css']
})
export class CurvePointAddComponent implements OnInit {

  newCurvePoint: CurvePoint = new CurvePoint();

  constructor(private curvePointService: CurvePointService) { }

  ngOnInit(): void {
  }

  onAdd(): void {
    this.curvePointService.creatingCurvePoint(this.newCurvePoint).subscribe();
  }

}
