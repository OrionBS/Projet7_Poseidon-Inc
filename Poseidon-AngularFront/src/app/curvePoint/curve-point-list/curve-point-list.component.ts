import { Component, OnInit } from '@angular/core';
import { CurvePoint } from '../curve-point';
import { CurvePointService } from '../curve-point.service';

@Component({
  selector: 'app-curve-point-list',
  templateUrl: './curve-point-list.component.html',
  styleUrls: ['./curve-point-list.component.css']
})
export class CurvePointListComponent implements OnInit {

  curvePointList: CurvePoint[] = [];

  constructor(private curvePointService: CurvePointService) { }

  ngOnInit(): void {
    this.curvePointService.readingAllCurvePoint().subscribe(curvePoints => this.curvePointList = curvePoints);
  }

  onDelete(id: any) {
    this.curvePointService.deletingCurvePoint(id).subscribe();
    let indexOf = this.curvePointList.findIndex(x =>x.id === id);
    this.curvePointList.splice(indexOf,1);
  }

}
