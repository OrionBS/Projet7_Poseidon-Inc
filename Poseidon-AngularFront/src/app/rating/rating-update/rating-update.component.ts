import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Rating } from '../rating';
import { RatingService } from '../rating.service';

@Component({
  selector: 'app-rating-update',
  templateUrl: './rating-update.component.html',
  styleUrls: ['./rating-update.component.css']
})
export class RatingUpdateComponent implements OnInit {

  updateRating: Rating = new Rating();

  constructor(private route: ActivatedRoute, private ratingService: RatingService) { }

  onUpdate() {
    this.ratingService.updatingRating(this.updateRating).subscribe();
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
       this.updateRating.id = +params['id'];
       });
    this.ratingService.readingRating(this.updateRating.id).subscribe(ratingFind => this.updateRating = ratingFind);
  }

}
