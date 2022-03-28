import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {CollectionService} from "../collection.service";

@Component({
  selector: 'app-collection-create',
  templateUrl: './collection-create.component.html',
  styleUrls: ['./collection-create.component.css']
})
export class CollectionCreateComponent implements OnInit {

  form!: FormGroup;

  constructor(
    public collectionService: CollectionService,
    private router: Router
  ) {
  }

  get getControls() {
    return this.form.controls;
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      name: new FormControl(''),
    });
  }

  submit() {
    console.log(this.form.value);
    this.collectionService.createCollection(this.form.controls['name'].value).subscribe((res: any) => {
      console.log('Wishlist created successfully!');
      this.router.navigateByUrl('collections');
    })
  }

}
