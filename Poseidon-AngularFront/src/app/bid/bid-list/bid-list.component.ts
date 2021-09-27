import { Component, OnInit } from '@angular/core';
import { Bid } from '../bid';
import { BidService } from '../bid.service';

@Component({
  selector: 'app-bid-list',
  templateUrl: './bid-list.component.html',
  styleUrls: ['./bid-list.component.css']
})
export class BidListComponent implements OnInit {

  bidList: Bid[] = [];

  constructor(private bidService: BidService) { }

  ngOnInit(): void {
    this.bidService.findAll().subscribe(bids => this.bidList = bids);
  }

  onDelete(id: any) {
    this.bidService.delete(id).subscribe();
    let indexOf = this.bidList.findIndex(x =>x.id === id);
    this.bidList.splice(indexOf,1);
  }

}
