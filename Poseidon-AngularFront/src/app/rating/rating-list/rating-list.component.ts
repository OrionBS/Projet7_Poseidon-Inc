import { Component, OnInit } from '@angular/core';
import { Rating } from '../rating';
import { RatingService } from '../rating.service';

@Component({
  selector: 'app-rating-list',
  templateUrl: './rating-list.component.html',
  styleUrls: ['./rating-list.component.css']
})
export class RatingListComponent implements OnInit {

  ratingList: Rating[] = [];

  constructor(private ratingService: RatingService) { }

  ngOnInit(): void {
    this.ratingService.readingAllRating().subscribe(ratings => this.ratingList = ratings);
  }

  onDelete(id: any) {
    this.ratingService.deletingRating(id).subscribe();
    let indexOf = this.ratingList.findIndex(x =>x.id === id);
    this.ratingList.splice(indexOf,1);
  }

}
