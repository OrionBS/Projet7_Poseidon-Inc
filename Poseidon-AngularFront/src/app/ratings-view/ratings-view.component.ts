import { Component, OnInit } from '@angular/core';

export interface RatingsObject {
  id: number;
  moodyRating: string;
  sAndPRating: string;
  fitchRating: string;
  orderNumber: number;
  action: any;
}

const ELEMENT_DATA: RatingsObject[] = [
  {id: 1, moodyRating: 'Account Moody', sAndPRating: 'Account S&P', fitchRating: 'Account Fitch', orderNumber: 10, action:''},
  {id: 2, moodyRating: 'Account Moody', sAndPRating: 'Account S&P', fitchRating: 'Account Fitch', orderNumber: 10, action:''},
  {id: 3, moodyRating: 'Account Moody', sAndPRating: 'Account S&P', fitchRating: 'Account Fitch', orderNumber: 10, action:''},
  {id: 4, moodyRating: 'Account Moody', sAndPRating: 'Account S&P', fitchRating: 'Account Fitch', orderNumber: 10, action:''},
  {id: 5, moodyRating: 'Account Moody', sAndPRating: 'Account S&P', fitchRating: 'Account Fitch', orderNumber: 10, action:''},
  {id: 6, moodyRating: 'Account Moody', sAndPRating: 'Account S&P', fitchRating: 'Account Fitch', orderNumber: 10, action:''},
];

@Component({
  selector: 'app-ratings-view',
  templateUrl: './ratings-view.component.html',
  styleUrls: ['./ratings-view.component.css']
})
export class RatingsViewComponent implements OnInit {

  displayedColumns: string[] = ['id', 'moodyRating', 'sAndPRating', 'fitchRating', 'orderNumber','action'];
  dataSource = ELEMENT_DATA;

  constructor() { }

  ngOnInit(): void {
  }

}
