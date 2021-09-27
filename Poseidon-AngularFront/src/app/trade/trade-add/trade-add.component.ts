import { Component, OnInit } from '@angular/core';
import { Trade } from '../trade';
import { TradeService } from '../trade.service';

@Component({
  selector: 'app-trade-add',
  templateUrl: './trade-add.component.html',
  styleUrls: ['./trade-add.component.css']
})
export class TradeAddComponent implements OnInit {

  newTrade: Trade = new Trade();

  constructor(private tradeService: TradeService) { }

  onAdd(): void {
    this.tradeService.creatingTrade(this.newTrade).subscribe();
  }

  ngOnInit(): void {
  }

}
