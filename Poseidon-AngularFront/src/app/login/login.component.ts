import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from './authenticate.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = '';
  password = '';

  constructor(private auth: AuthenticateService) { }

  ngOnInit(): void {
  }

  onLogin(): void {
    this.auth.login(this.username, this.password).subscribe();
  }

}
