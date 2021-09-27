import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { tap } from "rxjs/operators";
import { User } from "./user";

@Injectable({
    providedIn: 'root'
})
export class UserService {
    private URL = '/oapi/api/user';

    constructor(private http: HttpClient,  private router: Router) {

    }

    readingAllUser(): Observable<User[]> {
         return this.http.get<User[]>(this.URL);
    }

    readingUser(index?: number): Observable<User> {
        return this.http.get<User>(this.URL+"/"+index);
    }

    creatingUser(user: User): Observable<User> {
        console.log(user);
        return this.http.post<User>(this.URL, user).pipe(
            tap(b => this.router.navigate(['../users'])),
        );
    }

    updatingUser(user: User): Observable<User> {
        return this.http.put<User>(this.URL, user).pipe(
            tap(b => this.router.navigate(['../../users'])),
        )
    }

    deletingUser(index: number): Observable<unknown> {
        return this.http.delete(this.URL+'?index='+index).pipe();
    }
}
