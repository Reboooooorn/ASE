import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {IWishlist} from "../IWishlist";
import {ActivatedRoute, Router} from "@angular/router";
import {WishlistService} from "../wishlist.service";

@Component({
  selector: 'app-wishlist-add',
  templateUrl: './wishlist-add.component.html',
  styleUrls: ['./wishlist-add.component.css']
})
export class WishlistAddComponent implements OnInit {

  form!: FormGroup;
  wishlists: IWishlist[] = [];

  constructor(
    public wishlistService: WishlistService,
    private router: Router,
    private route: ActivatedRoute,
  ) {
  }

  get getControls() {
    return this.form.controls;
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      wishlistID: new FormControl(''),
    });
    this.wishlistService.getWishlists().subscribe(data => {
      this.wishlists = data;
    });
  }

  submit() {
    console.log(this.form.value);
    this.wishlistService.addPerfumeToWishlist(this.route.snapshot.params['perfumeID'], this.form.controls['wishlistID'].value).subscribe((res: any) => {
      console.log('Perfume was added successfully!');
      this.router.navigateByUrl('wishlists');
    })
  }

}
