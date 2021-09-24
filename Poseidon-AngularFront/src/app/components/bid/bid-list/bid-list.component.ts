import { Component, OnInit } from '@angular/core';
import { Bid } from '../../../models/bid';

@Component({
  selector: 'app-bid-list',
  templateUrl: './bid-list.component.html',
  styleUrls: ['./bid-list.component.css']
})
export class BidListComponent implements OnInit {

  bidList: Bid[] = [
    {id: 1, account: 'Orion', type: 'Trade', bidQuantity: 15}
  ];

  constructor() { }

  onDelete(id: any) {
    console.log("Bid "+id+" deleted.")
    this.bidList.splice(id-1, 1);
  }

  ngOnInit(): void {
  }

}
