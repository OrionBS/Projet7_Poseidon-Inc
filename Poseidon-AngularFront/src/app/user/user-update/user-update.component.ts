import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent implements OnInit {

  updateUser: User = new User();

  constructor(private route: ActivatedRoute, private userService: UserService) { }

  onUpdate() {
    this.userService.updatingUser(this.updateUser).subscribe();
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
       this.updateUser.id = +params['id'];
       });
    this.userService.readingUser(this.updateUser.id).subscribe(userFind => this.updateUser = userFind);
  }

}
