import {Component, OnInit} from '@angular/core';
import {WishlistService} from "../wishlist.service";
import {Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-wishlist-create',
  templateUrl: './wishlist-create.component.html',
  styleUrls: ['./wishlist-create.component.css']
})
export class WishlistCreateComponent implements OnInit {

  form!: FormGroup;

  constructor(
    public wishlistService: WishlistService,
    private router: Router
  ) {
  }

  get f() {
    return this.form.controls;
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      name: new FormControl('', [Validators.required]),
    });
  }

  submit() {
    console.log(this.form.value);
    this.wishlistService.createWishlist(this.form.controls['name'].value).subscribe((res: any) => {
      console.log('Wishlist created successfully!');
      this.router.navigateByUrl('wishlists');
    })
  }

}
