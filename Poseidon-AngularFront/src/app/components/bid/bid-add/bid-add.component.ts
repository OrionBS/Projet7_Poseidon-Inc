import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bid-add',
  templateUrl: './bid-add.component.html',
  styleUrls: ['./bid-add.component.css']
})
export class BidAddComponent implements OnInit {

  account: string = '';
  type: string = '';
  bidQuantity: number = 0;

  constructor() { }

  onAdd() {
    console.log(this.account,this.type,this.bidQuantity);
    //this.bidList.push(new Bid(this.account, this.type, this.bidQuantity));
  }

  ngOnInit(): void {
  }

}
