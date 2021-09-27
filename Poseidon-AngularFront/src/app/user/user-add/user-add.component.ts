import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.css']
})
export class UserAddComponent implements OnInit {

  newUser: User = new User();

  constructor(private userService: UserService) { }

  onAdd(): void {
    this.userService.creatingUser(this.newUser).subscribe();
  }

  ngOnInit(): void {
  }

}
