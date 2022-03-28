import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ICollection} from "../ICollection";
import {CollectionService} from "../collection.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-collection-add',
  templateUrl: './collection-add.component.html',
  styleUrls: ['./collection-add.component.css']
})
export class CollectionAddComponent implements OnInit {

  form!: FormGroup;
  collections: ICollection[] = [];

  constructor(
    public collectionService: CollectionService,
    private router: Router,
    private route: ActivatedRoute,
  ) {
  }

  get getControls() {
    return this.form.controls;
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      collectionID: new FormControl('', [Validators.required]),
    });
    this.collectionService.getCollections().subscribe(data => {
      this.collections = data;
    });
  }

  submit() {
    console.log(this.form.value);
    this.collectionService.addPerfumeToCollection(this.route.snapshot.params['perfumeID'], this.form.controls['collectionID'].value).subscribe((res: any) => {
      console.log('Perfume was added successfully!');
      this.router.navigateByUrl('collections');
    })
  }
}
