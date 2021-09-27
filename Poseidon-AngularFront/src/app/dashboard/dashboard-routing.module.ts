import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from 'src/app/dashboard/dashboard.component';
import { BidAddComponent } from '../bid/bid-add/bid-add.component';
import { BidListComponent } from '../bid/bid-list/bid-list.component';
import { BidUpdateComponent } from '../bid/bid-update/bid-update.component';
import { CurvePointListComponent } from '../curvePoint/curve-point-list/curve-point-list.component';
import { RatingListComponent } from '../rating/rating-list/rating-list.component';
import { RuleListComponent } from '../rule/rule-list/rule-list.component';
import { TradeListComponent } from '../trade/trade-list/trade-list.component';
import { UserListComponent } from '../user/user-list/user-list.component';

const routes: Routes = [
  // todo cabler le guard, et créer un home ou dashboard module qui contiendra le routage vers les modules métiers
  { path: '', component: DashboardComponent,
    children: [
      { path: 'bids', component: BidListComponent },
      { path: 'bids/add', component: BidAddComponent },
      { path: 'bids/update/:id', component: BidUpdateComponent },
      { path: 'curvePoints', component: CurvePointListComponent },
      { path: 'ratings', component: RatingListComponent },
      { path: 'trades', component: TradeListComponent },
      { path: 'rules', component: RuleListComponent },
      { path: 'users', component: UserListComponent },
    ]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
