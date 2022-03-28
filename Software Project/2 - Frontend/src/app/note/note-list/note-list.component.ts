import {Component, OnInit} from '@angular/core';
import {INote} from "../INote";
import {Router} from "@angular/router";
import {NoteService} from "../note.service";

@Component({
  selector: 'app-note-list',
  templateUrl: './note-list.component.html',
  styleUrls: ['./note-list.component.css']
})
export class NoteListComponent implements OnInit {

  baseNotes: INote[] = [];
  heartNotes: INote[] = [];
  headNotes: INote[] = [];


  constructor(private noteService: NoteService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getBaseNotes();
    this.getHeartNotes();
    this.getHeadNotes();
  }

  private getBaseNotes() {
    this.noteService.getBaseNoteList().subscribe(data => {
      this.baseNotes = data;
    });
  }

  private getHeartNotes() {
    this.noteService.getHeartNoteList().subscribe(data => {
      this.heartNotes = data;
    });
  }

  private getHeadNotes() {
    this.noteService.getHeadNoteList().subscribe(data => {
      this.headNotes = data;
    });
  }

}
