import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {IWishlist} from "./IWishlist";

@Injectable({
  providedIn: 'root'
})
export class WishlistService {
  private baseURL = "http://localhost:8080/api/wishlist";
  private createURL = "http://localhost:8080/api/uc/3";
  private addURL = "http://localhost:8080/api/uc/5b";

  constructor(private httpClient: HttpClient) {
  }

  getWishlists(): Observable<IWishlist[]> {
    return this.httpClient.get<IWishlist[]>(`${this.baseURL}`);
  }

  createWishlist(name: string): Observable<any> {
    return this.httpClient.post(this.createURL + "?wishlistName=" + name, "")
  }

  addPerfumeToWishlist(perfumeID: number, wishlistID: number) {
    return this.httpClient.post(this.addURL + "?perfumeID=" + perfumeID + "&wishlistID=" + wishlistID, "")
  }

}
