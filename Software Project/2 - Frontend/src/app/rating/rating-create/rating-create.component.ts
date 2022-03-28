import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {PerfumeService} from "../../perfume/perfume.service";
import {RatingService} from "../rating.service";
import {IPerfume} from "../../perfume/IPerfume";

@Component({
  selector: 'app-rating-create',
  templateUrl: './rating-create.component.html',
  styleUrls: ['./rating-create.component.css']
})
export class RatingCreateComponent implements OnInit {

  form!: FormGroup;
  perfumes: IPerfume[] = [];
  ratings: number[] = [];

  constructor(
    public ratingService: RatingService,
    public perfumeService: PerfumeService,
    private router: Router
  ) {
  }

  get getControl() {
    return this.form.controls;
  }

  ngOnInit(): void {
    this.perfumeService.getPerfumes().subscribe(data => {
      this.perfumes = data;
    });
    this.ratings = [...Array(11).keys()]
    this.form = new FormGroup({
      user: new FormControl('', [Validators.required]),
      perfumeResource: new FormControl('',),
      value_scent: new FormControl('0'),
      value_durability: new FormControl('0'),
      value_sillage: new FormControl('0'),
      value_vial: new FormControl('0'),
      value_charge: new FormControl('0')
    });
  }

  submit() {
    console.log(this.form.value);
    this.ratingService.createRating(this.form.value).subscribe((res: any) => {
      console.log('Rating created successfully!');
      this.router.navigateByUrl('ratings');
    })
  }

}
