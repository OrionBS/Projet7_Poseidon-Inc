import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BidsViewComponent } from './bids-view/bids-view.component';
import { CurvePointsViewComponent } from './curve-points-view/curve-points-view.component';
import { RatingsViewComponent } from './ratings-view/ratings-view.component';
import { TradesViewComponent } from './trades-view/trades-view.component';
import { RulesViewComponent } from './rules-view/rules-view.component';
import { LoginViewComponent } from './login-view/login-view.component';
import { AddBidViewComponent } from './add-bid-view/add-bid-view.component';
import { UpdateBidViewComponent } from './update-bid-view/update-bid-view.component';
import { AddCurvePointViewComponent } from './add-curve-point-view/add-curve-point-view.component';
import { UpdateCurvePointViewComponent } from './update-curve-point-view/update-curve-point-view.component';
import { AddRatingViewComponent } from './add-rating-view/add-rating-view.component';
import { UpdateRatingViewComponent } from './update-rating-view/update-rating-view.component';
import { AddTradeViewComponent } from './add-trade-view/add-trade-view.component';
import { UpdateTradeViewComponent } from './update-trade-view/update-trade-view.component';
import { AddRuleViewComponent } from './add-rule-view/add-rule-view.component';
import { UpdateRuleViewComponent } from './update-rule-view/update-rule-view.component';
import { NotFoundViewComponent } from './not-found-view/not-found-view.component';

const routes: Routes = [
  {path: 'bids', component: BidsViewComponent},
  {path: 'curvePoints', component: CurvePointsViewComponent},
  {path: 'ratings', component: RatingsViewComponent},
  {path: 'trades', component: TradesViewComponent},
  {path: 'rules', component: RulesViewComponent},
  {path: '', component: LoginViewComponent},
  {path: 'bids/addBid', component: AddBidViewComponent},
  {path: 'bids/updateBid/:id', component: UpdateBidViewComponent},
  {path: 'curvePoints/addCurvePoint', component: AddCurvePointViewComponent},
  {path: 'curvePoints/updateCurvePoint/:id', component: UpdateCurvePointViewComponent},
  {path: 'ratings/addRating', component: AddRatingViewComponent},
  {path: 'ratings/updateRating/:id', component: UpdateRatingViewComponent},
  {path: 'trades/addTrade', component: AddTradeViewComponent},
  {path: 'trades/updateTrade/:id', component: UpdateTradeViewComponent},
  {path: 'rules/addRule', component: AddRuleViewComponent},
  {path: 'rules/updateRule/:id', component: UpdateRuleViewComponent},
  {path: 'notFound', component: NotFoundViewComponent},
  {path: '**', component: NotFoundViewComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
