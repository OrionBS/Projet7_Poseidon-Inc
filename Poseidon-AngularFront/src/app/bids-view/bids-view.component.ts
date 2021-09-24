import { Component, OnInit } from '@angular/core';
import { Bid } from '../models/bid';

@Component({
  selector: 'app-bids-view',
  templateUrl: './bids-view.component.html',
  styleUrls: ['./bids-view.component.css']
})
export class BidsViewComponent implements OnInit{

  account: string = '';
  type: string = '';
  bidQuantity: number = 0;

  bidList: Bid[] = [
    {id: 1, account: 'Orion', type: 'Trade', bidQuantity: 15}
  ];

  constructor() { }

  onSubmit() {
    console.log(this.account,this.type,this.bidQuantity);
    this.bidList.push(new Bid(this.account, this.type, this.bidQuantity));
  }

  onUpdate() {
    let updateBid: Bid = new Bid(account, type, bidQuantity);
    updateBid.id = id;
    console.log("Bid "+id+" updated." );
    this.bidList[id-1] = updateBid;
  }

  onDelete(id: any) {
    console.log("Bid "+id+" deleted.")
    this.bidList.splice(id-1, 1);
  }

  ngOnInit(): void {
  }

}
