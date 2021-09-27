import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { tap } from "rxjs/operators";
import { Bid } from "./bid";

@Injectable({
    providedIn: 'root'
})
export class BidService {
    private URL = '/oapi/api/bid';

    constructor(private http: HttpClient,  private router: Router) {

    }

    findAll(): Observable<Bid[]> {
         return this.http.get<Bid[]>(this.URL);
    }

    getBid(index?: number): Observable<Bid> {
        return this.http.get<Bid>(this.URL+"/"+index);
    }

    create(bid: Bid): Observable<Bid> {
        console.log(bid);
        return this.http.post<Bid>(this.URL, bid).pipe(
            tap(b => this.router.navigate(['../bids'])),
        );
    }

    updateBid(bid: Bid): Observable<Bid> {
        return this.http.put<Bid>(this.URL,bid).pipe(
            tap(b => this.router.navigate(['../../bids'])),
        )
    }

    delete(index: number): Observable<unknown> {
        return this.http.delete(this.URL+'?index='+index).pipe();
    }
}
