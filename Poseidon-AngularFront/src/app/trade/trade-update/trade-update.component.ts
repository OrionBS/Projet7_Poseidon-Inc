import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Trade } from '../trade';
import { TradeService } from '../trade.service';

@Component({
  selector: 'app-trade-update',
  templateUrl: './trade-update.component.html',
  styleUrls: ['./trade-update.component.css']
})
export class TradeUpdateComponent implements OnInit {

  updateTrade: Trade = new Trade();

  constructor(private route: ActivatedRoute, private tradeService: TradeService) { }

  onUpdate() {
    this.tradeService.updatingTrade(this.updateTrade).subscribe();
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
       this.updateTrade.id = +params['id'];
       });
    this.tradeService.readingTrade(this.updateTrade.id).subscribe(tradeFind => this.updateTrade = tradeFind);
  }

}
