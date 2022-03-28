import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {ICollection} from "../ICollection";
import {CollectionService} from "../collection.service";

@Component({
  selector: 'app-collection-list',
  templateUrl: './collection-list.component.html',
  styleUrls: ['./collection-list.component.css']
})
export class CollectionListComponent implements OnInit {

  collections: ICollection[] = [];

  constructor(private collectionService: CollectionService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getCollections();
  }

  private getCollections() {
    this.collectionService.getCollections().subscribe(data => {
      this.collections = data;
    });
  }

}
