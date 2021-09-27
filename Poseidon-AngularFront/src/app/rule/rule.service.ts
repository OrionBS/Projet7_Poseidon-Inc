import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { tap } from "rxjs/operators";
import { Rule } from "./rule";

@Injectable({
    providedIn: 'root'
})
export class RuleService {
    private URL = '/oapi/api/rule';

    constructor(private http: HttpClient,  private router: Router) {

    }

    readingAllRule(): Observable<Rule[]> {
         return this.http.get<Rule[]>(this.URL);
    }

    readingRule(index?: number): Observable<Rule> {
        return this.http.get<Rule>(this.URL+"/"+index);
    }

    creatingRule(rule: Rule): Observable<Rule> {
        console.log(rule);
        return this.http.post<Rule>(this.URL, rule).pipe(
            tap(b => this.router.navigate(['../rules'])),
        );
    }

    updatingRule(rule: Rule): Observable<Rule> {
        return this.http.put<Rule>(this.URL, rule).pipe(
            tap(b => this.router.navigate(['../../rules'])),
        )
    }

    deletingRule(index: number): Observable<unknown> {
        return this.http.delete(this.URL+'?index='+index).pipe();
    }
}
