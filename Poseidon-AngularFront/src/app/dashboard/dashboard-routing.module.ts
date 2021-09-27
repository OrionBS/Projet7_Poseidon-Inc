import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from 'src/app/dashboard/dashboard.component';
import { BidAddComponent } from '../bid/bid-add/bid-add.component';
import { BidListComponent } from '../bid/bid-list/bid-list.component';
import { BidUpdateComponent } from '../bid/bid-update/bid-update.component';
import { CurvePointAddComponent } from '../curvePoint/curve-point-add/curve-point-add.component';
import { CurvePointListComponent } from '../curvePoint/curve-point-list/curve-point-list.component';
import { CurvePointUpdateComponent } from '../curvePoint/curve-point-update/curve-point-update.component';
import { RatingAddComponent } from '../rating/rating-add/rating-add.component';
import { RatingListComponent } from '../rating/rating-list/rating-list.component';
import { RatingUpdateComponent } from '../rating/rating-update/rating-update.component';
import { RuleAddComponent } from '../rule/rule-add/rule-add.component';
import { RuleListComponent } from '../rule/rule-list/rule-list.component';
import { RuleUpdateComponent } from '../rule/rule-update/rule-update.component';
import { TradeAddComponent } from '../trade/trade-add/trade-add.component';
import { TradeListComponent } from '../trade/trade-list/trade-list.component';
import { TradeUpdateComponent } from '../trade/trade-update/trade-update.component';
import { UserAddComponent } from '../user/user-add/user-add.component';
import { UserListComponent } from '../user/user-list/user-list.component';
import { UserUpdateComponent } from '../user/user-update/user-update.component';

const routes: Routes = [
  // todo cabler le guard, et créer un home ou dashboard module qui contiendra le routage vers les modules métiers
  { path: '', component: DashboardComponent,
    children: [
      { path: 'bids', component: BidListComponent },
      { path: 'bids/add', component: BidAddComponent },
      { path: 'bids/update/:id', component: BidUpdateComponent },
      { path: 'curvePoints', component: CurvePointListComponent },
      { path: 'curvePoints/add', component: CurvePointAddComponent },
      { path: 'curvePoints/update/:id', component: CurvePointUpdateComponent },
      { path: 'ratings', component: RatingListComponent },
      { path: 'ratings/add', component: RatingAddComponent },
      { path: 'ratings/update/:id', component: RatingUpdateComponent },
      { path: 'trades', component: TradeListComponent },
      { path: 'trades/add', component: TradeAddComponent },
      { path: 'trades/update/:id', component: TradeUpdateComponent },
      { path: 'rules', component: RuleListComponent },
      { path: 'rules/add', component: RuleAddComponent },
      { path: 'rules/update/:id', component: RuleUpdateComponent },
      { path: 'users', component: UserListComponent },
      { path: 'users/add', component: UserAddComponent },
      { path: 'users/update/:id', component: UserUpdateComponent },
    ]},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
