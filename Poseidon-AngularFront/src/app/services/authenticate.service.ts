import { Injectable } from '@angular/core';
import { HttpClient, Response } from '@angular/http';
import { Credentials } from '../models/credentials';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  constructor(private http: HttpClient) { }

  sendCredentials(): void {
    console.log("Send Credentials");
  }
}
