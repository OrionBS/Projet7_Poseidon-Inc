import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { tap } from "rxjs/operators";
import { Trade } from "./trade";

@Injectable({
    providedIn: 'root'
})
export class TradeService {
    private URL = '/oapi/api/trade';

    constructor(private http: HttpClient,  private router: Router) {

    }

    readingAllTrade(): Observable<Trade[]> {
         return this.http.get<Trade[]>(this.URL);
    }

    readingTrade(index?: number): Observable<Trade> {
        return this.http.get<Trade>(this.URL+"/"+index);
    }

    creatingTrade(trade: Trade): Observable<Trade> {
        console.log(trade);
        return this.http.post<Trade>(this.URL, trade).pipe(
            tap(b => this.router.navigate(['../trades'])),
        );
    }

    updatingTrade(trade: Trade): Observable<Trade> {
        return this.http.put<Trade>(this.URL, trade).pipe(
            tap(b => this.router.navigate(['../../trades'])),
        )
    }

    deletingTrade(index: number): Observable<unknown> {
        return this.http.delete(this.URL+'?index='+index).pipe();
    }
}
