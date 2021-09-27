import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Bid } from '../bid';
import { BidService } from '../bid.service';


@Component({
  selector: 'app-bid-update',
  templateUrl: './bid-update.component.html',
  styleUrls: ['./bid-update.component.css']
})
export class BidUpdateComponent implements OnInit {

  updateBid: Bid = new Bid('','',0);

  constructor(private route: ActivatedRoute, private bidService: BidService) { }

  onUpdate() {
    this.bidService.updatingBid(this.updateBid).subscribe();
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
       this.updateBid.id = +params['id'];
       });
    this.bidService.readingBid(this.updateBid.id).subscribe(bidFind => this.updateBid = bidFind);
  }

}
