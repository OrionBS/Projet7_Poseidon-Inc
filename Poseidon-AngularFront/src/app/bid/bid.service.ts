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

    readingAllBid(): Observable<Bid[]> {
         return this.http.get<Bid[]>(this.URL);
    }

    readingBid(index?: number): Observable<Bid> {
        return this.http.get<Bid>(this.URL+"/"+index);
    }

    creatingBid(bid: Bid): Observable<Bid> {
        console.log(bid);
        return this.http.post<Bid>(this.URL, bid).pipe(
            tap(b => this.router.navigate(['../bids'])),
        );
    }

    updatingBid(bid: Bid): Observable<Bid> {
        return this.http.put<Bid>(this.URL, bid).pipe(
            tap(b => this.router.navigate(['../../bids'])),
        )
    }

    deletingBid(index: number): Observable<unknown> {
        return this.http.delete(this.URL+'?index='+index).pipe();
    }
}
