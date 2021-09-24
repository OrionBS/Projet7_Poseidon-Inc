import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { BidListComponent } from './components/bid/bid-list/bid-list.component';
import { BidAddComponent } from './components/bid/bid-add/bid-add.component';
import { BidUpdateComponent } from './components/bid/bid-update/bid-update.component';
import { CurvePointListComponent } from './components/curvePoint/curve-point-list/curve-point-list.component';
import { CurvePointAddComponent } from './components/curvePoint/curve-point-add/curve-point-add.component';
import { CurvePointUpdateComponent } from './components/curvePoint/curve-point-update/curve-point-update.component';
import { RatingUpdateComponent } from './components/rating/rating-update/rating-update.component';
import { RatingAddComponent } from './components/rating/rating-add/rating-add.component';
import { RatingListComponent } from './components/rating/rating-list/rating-list.component';
import { RuleListComponent } from './components/rule/rule-list/rule-list.component';
import { RuleAddComponent } from './components/rule/rule-add/rule-add.component';
import { RuleUpdateComponent } from './components/rule/rule-update/rule-update.component';
import { TradeUpdateComponent } from './components/trade/trade-update/trade-update.component';
import { TradeAddComponent } from './components/trade/trade-add/trade-add.component';
import { TradeListComponent } from './components/trade/trade-list/trade-list.component';
import { LoginComponent } from './components/login/login.component';
import { UserAddComponent } from './components/user/user-add/user-add.component';
import { UserListComponent } from './components/user/user-list/user-list.component';
import { UserUpdateComponent } from './components/user/user-update/user-update.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'bids', component: BidListComponent },
  { path: 'bids/add', component: BidAddComponent },
  { path: 'bids/update/:id', component: BidUpdateComponent },
  { path: 'curvePoints', component: CurvePointListComponent },
  { path: 'ratings', component: RatingListComponent },
  { path: 'trades', component: TradeListComponent },
  { path: 'rules', component: RuleListComponent },
  { path: 'users', component: UserListComponent },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
