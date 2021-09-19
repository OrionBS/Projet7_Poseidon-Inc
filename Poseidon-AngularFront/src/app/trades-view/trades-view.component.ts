import { Component, OnInit } from '@angular/core';

export interface TradesObject {
  id: number;
  account: string;
  type: string;
  buyQuantity: number;
  action: any;
}

const ELEMENT_DATA: TradesObject[] = [
  {id: 1, account: 'Account Name', type: 'Account Type', buyQuantity: 10, action:''},
  {id: 2, account: 'Account Name', type: 'Account Type', buyQuantity: 10, action:''},
  {id: 3, account: 'Account Name', type: 'Account Type', buyQuantity: 10, action:''},
  {id: 4, account: 'Account Name', type: 'Account Type', buyQuantity: 10, action:''},
  {id: 5, account: 'Account Name', type: 'Account Type', buyQuantity: 10, action:''},
  {id: 6, account: 'Account Name', type: 'Account Type', buyQuantity: 10, action:''},

];

@Component({
  selector: 'app-trades-view',
  templateUrl: './trades-view.component.html',
  styleUrls: ['./trades-view.component.css']
})
export class TradesViewComponent implements OnInit {

  displayedColumns: string[] = ['id', 'account', 'type', 'buyQuantity', 'action'];
  dataSource = ELEMENT_DATA;

  constructor() { }

  ngOnInit(): void {
  }

}
