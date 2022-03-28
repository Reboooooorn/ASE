import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CollectionService} from "../../collection/collection.service";
import {Router} from "@angular/router";
import {IManufacturer} from "../../manufacturer/IManufacturer";
import {INote} from "../../note/INote";
import {ICollection} from "../../collection/ICollection";
import {ManufacturerService} from "../../manufacturer/manufacturer.service";
import {NoteService} from "../../note/note.service";
import {PerfumeService} from "../perfume.service";

@Component({
  selector: 'app-perfume-create',
  templateUrl: './perfume-create.component.html',
  styleUrls: ['./perfume-create.component.css']
})
export class PerfumeCreateComponent implements OnInit {

  form!: FormGroup;
  manufacturers: IManufacturer[] = [];
  basenotes: INote[] = [];
  heartnotes: INote[] = [];
  headnotes: INote[] = [];
  collections: ICollection [] = [];

  constructor(
    public perfumeService: PerfumeService,
    public collectionService: CollectionService,
    public manufacturerService: ManufacturerService,
    public noteService: NoteService,
    private router: Router
  ) {
  }

  get getControls() {
    return this.form.controls;
  }

  ngOnInit(): void {
    this.form = new FormGroup({
      name: new FormControl('', [Validators.required]),
      yearOfManufacture: new FormControl('', [Validators.required]),
      manufacturer: new FormControl('', [Validators.required]),
      sizeInMilliliter: new FormControl('', [Validators.required]),
      basicNote: new FormControl('', [Validators.required]),
      heartNote: new FormControl('', [Validators.required]),
      headNote: new FormControl('', [Validators.required]),
      collectionName: new FormControl(null)
    });
    this.manufacturerService.getManufacturerList().subscribe((data: IManufacturer[]) => {
      this.manufacturers = data;
    })
    this.noteService.getBaseNoteList().subscribe((data: INote[]) => {
      this.basenotes = data;
    })
    this.noteService.getHeartNoteList().subscribe((data: INote[]) => {
      this.heartnotes = data;
    })
    this.noteService.getHeadNoteList().subscribe((data: INote[]) => {
      this.headnotes = data;
    })
    this.collectionService.getCollections().subscribe((data: ICollection[]) => {
      this.collections = data;
    })
  }

  submit() {
    console.log(this.form.value);
    this.perfumeService.createPerfume(this.form.value).subscribe((res: any) => {
      console.log('Perfume created successfully!');
      this.router.navigateByUrl('perfumes');
    })
  }

}
