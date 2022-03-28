import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {IRating} from "../IRating";
import {RatingService} from "../rating.service";

@Component({
  selector: 'app-rating-list',
  templateUrl: './rating-list.component.html',
  styleUrls: ['./rating-list.component.css']
})
export class RatingListComponent implements OnInit {

  ratings: IRating[] = [];

  constructor(private ratingService: RatingService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getRatings();
  }

  private getRatings() {
    this.ratingService.getRatings().subscribe(data => {
      this.ratings = data;
    });
  }

}
