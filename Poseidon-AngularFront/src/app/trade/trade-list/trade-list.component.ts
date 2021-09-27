import { Component, OnInit } from '@angular/core';
import { Trade } from '../trade';
import { TradeService } from '../trade.service';

@Component({
  selector: 'app-trade-list',
  templateUrl: './trade-list.component.html',
  styleUrls: ['./trade-list.component.css']
})
export class TradeListComponent implements OnInit {

  tradeList: Trade[] = [];

  constructor(private tradeService: TradeService) { }

  ngOnInit(): void {
    this.tradeService.readingAllTrade().subscribe(trades => this.tradeList = trades);
  }

  onDelete(id: any) {
    this.tradeService.deletingTrade(id).subscribe();
    let indexOf = this.tradeList.findIndex(x =>x.id === id);
    this.tradeList.splice(indexOf,1);
  }

}
