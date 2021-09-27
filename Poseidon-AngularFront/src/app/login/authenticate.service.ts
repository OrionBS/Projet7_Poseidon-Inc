import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {map, tap} from 'rxjs/operators';
import { Router } from '@angular/router';
import { Token } from './token';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  private readonly URL = '/oapi/authenticate';
  static TOKEN = 'jwt';

  constructor(private http: HttpClient, private router: Router) { }

  login(username: string, password: string): Observable<Token> {
    return this.http.post<Token>(this.URL, { username, password }).pipe(
      map(t => new Token(t)),
      tap(t => localStorage.setItem(AuthenticateService.TOKEN, t.token)),
      // rediriger sur /home après avoir mis en place un guard
      tap(t => this.router.navigate(['/bids'])),
    );
  }

  getJwt(): string {
    return <string> localStorage.getItem(AuthenticateService.TOKEN);
  }
}
