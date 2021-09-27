import { Component, OnInit } from '@angular/core';
import { Bid } from '../bid';
import { BidService } from '../bid.service';

@Component({
  selector: 'app-bid-add',
  templateUrl: './bid-add.component.html',
  styleUrls: ['./bid-add.component.css']
})
export class BidAddComponent implements OnInit {

  newBid: Bid = new Bid('','',0);

  constructor(private bidService: BidService) { }

  onAdd(): void {
    this.bidService.creatingBid(this.newBid).subscribe();
  }

  ngOnInit(): void {
  }

}
