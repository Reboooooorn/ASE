import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {WishlistService} from "../wishlist.service";
import {IWishlist} from "../IWishlist";

@Component({
  selector: 'app-wishlist-list',
  templateUrl: './wishlist-list.component.html',
  styleUrls: ['./wishlist-list.component.css']
})
export class WishlistListComponent implements OnInit {

  wishlists: IWishlist[] = [];

  constructor(private wishlistService: WishlistService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getWishlists();
  }

  private getWishlists() {
    this.wishlistService.getWishlists().subscribe(data => {
      this.wishlists = data;
    });
  }

}
