import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  userList: User[] = [];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.readingAllUser().subscribe(users => this.userList = users);
  }

  onDelete(id: any) {
    this.userService.deletingUser(id).subscribe();
    let indexOf = this.userList.findIndex(x =>x.id === id);
    this.userList.splice(indexOf,1);
  }

}
