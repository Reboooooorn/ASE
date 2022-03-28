import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CountryListComponent} from './country/country-list/country-list.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ManufacturerListComponent} from './manufacturer/manufacturer-list/manufacturer-list.component';
import {NoteListComponent} from './note/note-list/note-list.component';
import {CollectionListComponent} from './collection/collection-list/collection-list.component';
import {PerfumeListComponent} from './perfume/perfume-list/perfume-list.component';
import {WishlistListComponent} from './wishlist/wishlist-list/wishlist-list.component';
import {RatingListComponent} from './rating/rating-list/rating-list.component';
import {WishlistCreateComponent} from './wishlist/wishlist-create/wishlist-create.component';
import {CollectionCreateComponent} from './collection/collection-create/collection-create.component';
import {PerfumeCreateComponent} from './perfume/perfume-create/perfume-create.component';
import {CollectionAddComponent} from './collection/collection-add/collection-add.component';
import {WishlistAddComponent} from './wishlist/wishlist-add/wishlist-add.component';
import {RatingCreateComponent} from './rating/rating-create/rating-create.component';

@NgModule({
  declarations: [
    AppComponent,
    CountryListComponent,
    ManufacturerListComponent,
    NoteListComponent,
    CollectionListComponent,
    PerfumeListComponent,
    WishlistListComponent,
    RatingListComponent,
    WishlistCreateComponent,
    CollectionCreateComponent,
    PerfumeCreateComponent,
    CollectionAddComponent,
    WishlistAddComponent,
    RatingCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
