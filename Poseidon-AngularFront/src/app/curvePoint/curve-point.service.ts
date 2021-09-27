import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { tap } from "rxjs/operators";
import { CurvePoint } from "./curve-point";

@Injectable({
    providedIn: 'root'
})
export class CurvePointService{
    private URL = '/oapi/api/curve-point';

    constructor(private http: HttpClient,  private router: Router) {

    }

    readingAllCurvePoint(): Observable<CurvePoint[]> {
         return this.http.get<CurvePoint[]>(this.URL);
    }

    readingCurvePoint(index?: number): Observable<CurvePoint> {
        return this.http.get<CurvePoint>(this.URL+"/"+index);
    }

    creatingCurvePoint(curvePoint: CurvePoint): Observable<CurvePoint> {
        console.log(curvePoint);
        return this.http.post<CurvePoint>(this.URL, curvePoint).pipe(
            tap(b => this.router.navigate(['../curvePoints'])),
        );
    }

    updatingCurvePoint(curvePoint: CurvePoint): Observable<CurvePoint> {
        return this.http.put<CurvePoint>(this.URL, curvePoint).pipe(
            tap(b => this.router.navigate(['../../curvePoints'])),
        )
    }

    deletingCurvePoint(index: number): Observable<unknown> {
        return this.http.delete(this.URL+'?index='+index).pipe();
    }
}