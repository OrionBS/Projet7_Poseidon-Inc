import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { tap } from "rxjs/operators";
import { Rating } from "./rating";

@Injectable({
    providedIn: 'root'
})
export class RatingService {
    private URL = '/oapi/api/rating';

    constructor(private http: HttpClient,  private router: Router) {

    }

    readingAllRating(): Observable<Rating[]> {
         return this.http.get<Rating[]>(this.URL);
    }

    readingRating(index?: number): Observable<Rating> {
        return this.http.get<Rating>(this.URL+"/"+index);
    }

    creatingRating(rating: Rating): Observable<Rating> {
        console.log(rating);
        return this.http.post<Rating>(this.URL, rating).pipe(
            tap(b => this.router.navigate(['../ratings'])),
        );
    }

    updatingRating(rating: Rating): Observable<Rating> {
        return this.http.put<Rating>(this.URL, rating).pipe(
            tap(b => this.router.navigate(['../../ratings'])),
        )
    }

    deletingRating(index: number): Observable<unknown> {
        return this.http.delete(this.URL+'?index='+index).pipe();
    }
}
