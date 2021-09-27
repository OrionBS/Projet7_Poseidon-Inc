import { Component, OnInit } from '@angular/core';
import { Rating } from '../rating';
import { RatingService } from '../rating.service';

@Component({
  selector: 'app-rating-add',
  templateUrl: './rating-add.component.html',
  styleUrls: ['./rating-add.component.css']
})
export class RatingAddComponent implements OnInit {

  newRating: Rating = new Rating();

  constructor(private ratingService: RatingService) { }

  onAdd(): void {
    this.ratingService.creatingRating(this.newRating).subscribe();
  }

  ngOnInit(): void {
  }

}
