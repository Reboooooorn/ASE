import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CountryListComponent} from "./country/country-list/country-list.component";
import {ManufacturerListComponent} from "./manufacturer/manufacturer-list/manufacturer-list.component";
import {NoteListComponent} from "./note/note-list/note-list.component";
import {PerfumeListComponent} from "./perfume/perfume-list/perfume-list.component";
import {CollectionListComponent} from "./collection/collection-list/collection-list.component";
import {WishlistListComponent} from "./wishlist/wishlist-list/wishlist-list.component";
import {RatingListComponent} from "./rating/rating-list/rating-list.component";
import {WishlistCreateComponent} from "./wishlist/wishlist-create/wishlist-create.component";
import {CollectionCreateComponent} from "./collection/collection-create/collection-create.component";
import {PerfumeCreateComponent} from "./perfume/perfume-create/perfume-create.component";
import {CollectionAddComponent} from "./collection/collection-add/collection-add.component";
import {WishlistAddComponent} from "./wishlist/wishlist-add/wishlist-add.component";
import {RatingCreateComponent} from "./rating/rating-create/rating-create.component";

const routes: Routes = [
  {path: 'countrys', component: CountryListComponent},
  {path: 'manufacturers', component: ManufacturerListComponent},
  {path: 'notes', component: NoteListComponent},
  {path: 'perfumes', component: PerfumeListComponent},
  {path: 'perfume/create', component: PerfumeCreateComponent},
  {path: 'collections', component: CollectionListComponent},
  {path: 'collection/create', component: CollectionCreateComponent},
  {path: 'collection/:perfumeID/add', component: CollectionAddComponent},
  {path: 'wishlists', component: WishlistListComponent},
  {path: 'wishlist/create', component: WishlistCreateComponent},
  {path: 'wishlist/:perfumeID/add', component: WishlistAddComponent},
  {path: 'ratings', component: RatingListComponent},
  {path: 'rating/create', component: RatingCreateComponent},
  {path: '', redirectTo: 'countrys', pathMatch: 'full'},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
