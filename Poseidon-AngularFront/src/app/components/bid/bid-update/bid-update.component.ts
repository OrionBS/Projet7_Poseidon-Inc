import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Bid } from '../../../models/bid';


@Component({
  selector: 'app-bid-update',
  templateUrl: './bid-update.component.html',
  styleUrls: ['./bid-update.component.css']
})
export class BidUpdateComponent implements OnInit {

  id: any;
  private sub: any;
  account: string = '';
  type: string = '';
  bidQuantity?: number;

  constructor(private route: ActivatedRoute) { }

  onUpdate() {
    let updateBid: Bid = new Bid(this.account, this.type, this.bidQuantity);
    updateBid.id = this.id;
    console.log("Bid "+this.id+" updated.");
    //this.bidList[id-1] = updateBid;
  }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
       this.id = +params['id'];
       });
  }

}
