import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {IPerfume} from "../IPerfume";
import {PerfumeService} from "../perfume.service";

@Component({
  selector: 'app-perfume-list',
  templateUrl: './perfume-list.component.html',
  styleUrls: ['./perfume-list.component.css']
})
export class PerfumeListComponent implements OnInit {

  perfumes: IPerfume[] = [];

  constructor(private perfumeService: PerfumeService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getPerfumes();
  }

  private getPerfumes() {
    this.perfumeService.getPerfumes().subscribe(data => {
      this.perfumes = data;
    });
  }

}
