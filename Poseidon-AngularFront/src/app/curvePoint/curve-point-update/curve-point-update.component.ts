import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CurvePoint } from '../curve-point';
import { CurvePointService } from '../curve-point.service';

@Component({
  selector: 'app-curve-point-update',
  templateUrl: './curve-point-update.component.html',
  styleUrls: ['./curve-point-update.component.css']
})
export class CurvePointUpdateComponent implements OnInit {

  updateCurvePoint: CurvePoint = new CurvePoint();

  constructor(private route: ActivatedRoute, private curvePointService: CurvePointService) { }

  onUpdate() {
    this.curvePointService.updatingCurvePoint(this.updateCurvePoint).subscribe();
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
       this.updateCurvePoint.id = +params['id'];
       });
    this.curvePointService.readingCurvePoint(this.updateCurvePoint.id).subscribe(curvePointFind => this.updateCurvePoint = curvePointFind);
  }

}
