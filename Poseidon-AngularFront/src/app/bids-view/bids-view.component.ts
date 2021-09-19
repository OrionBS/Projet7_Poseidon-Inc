import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

export interface BidObject {
  id: number;
  account: string;
  type: string;
  bidQuantity: number;
  action: any;
}

const ELEMENT_DATA: BidObject[] = [
  {id: 1, account: 'Account Name', type: 'Account Type', bidQuantity: 10.0, action:''},
  {id: 2, account: 'Account Name', type: 'Account Type', bidQuantity: 10.0, action:''},
  {id: 3, account: 'Account Name', type: 'Account Type', bidQuantity: 10.0, action:''},
  {id: 4, account: 'Account Name', type: 'Account Type', bidQuantity: 10.0, action:''},
  {id: 5, account: 'Account Name', type: 'Account Type', bidQuantity: 10.0, action:''},
  {id: 6, account: 'Account Name', type: 'Account Type', bidQuantity: 10.0, action:''},
];

@Component({
  selector: 'app-bids-view',
  templateUrl: './bids-view.component.html',
  styleUrls: ['./bids-view.component.css']
})
export class BidsViewComponent implements OnInit {

  displayedColumns: string[] = ['id', 'account', 'type', 'bidQuantity', 'action'];
  dataSource = ELEMENT_DATA;

  constructor() { }

  ngOnInit(): void {
  }

}
