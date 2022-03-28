import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {IManufacturer} from "../IManufacturer";
import {ManufacturerService} from "../manufacturer.service";

@Component({
  selector: 'app-manufacturer-list',
  templateUrl: './manufacturer-list.component.html',
  styleUrls: ['./manufacturer-list.component.css']
})
export class ManufacturerListComponent implements OnInit {

  manufacturers: IManufacturer[] = [];

  constructor(private manufacturerService: ManufacturerService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getManufacturers();
  }

  private getManufacturers() {
    this.manufacturerService.getManufacturerList().subscribe(data => {
      this.manufacturers = data;
    });
  }

}
