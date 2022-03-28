import {Component, OnInit} from '@angular/core';
import {ICountry} from "../ICountry";
import {CountryService} from "../country.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-country-list',
  templateUrl: './country-list.component.html',
  styleUrls: ['./country-list.component.css']
})
export class CountryListComponent implements OnInit {

  countrys: ICountry[] = [];

  constructor(private countryService: CountryService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getCountrys();
  }

  private getCountrys() {
    this.countryService.getCountryList().subscribe(data => {
      this.countrys = data;
    });
  }

}
