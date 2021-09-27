import { NgModule } from '@angular/core';
import { DashboardComponent } from './dashboard.component';

import { SharedModule } from 'src/app/shared/shared.module';
import { DashboardRoutingModule } from 'src/app/dashboard/dashboard-routing.module';
import { BidAddComponent } from '../bid/bid-add/bid-add.component';
import { CurvePointListComponent } from '../curvePoint/curve-point-list/curve-point-list.component';
import { BidListComponent } from '../bid/bid-list/bid-list.component';
import { BidUpdateComponent } from '../bid/bid-update/bid-update.component';
import { CurvePointAddComponent } from '../curvePoint/curve-point-add/curve-point-add.component';
import { CurvePointUpdateComponent } from '../curvePoint/curve-point-update/curve-point-update.component';
import { NotFoundComponent } from '../not-found/not-found.component';
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




@NgModule({
  declarations: [
    DashboardComponent,
    NotFoundComponent,
    BidListComponent,
    BidAddComponent,
    BidUpdateComponent,
    CurvePointListComponent,
    CurvePointAddComponent,
    CurvePointUpdateComponent,
    RatingUpdateComponent,
    RatingAddComponent,
    RatingListComponent,
    RuleListComponent,
    RuleAddComponent,
    RuleUpdateComponent,
    TradeUpdateComponent,
    TradeAddComponent,
    TradeListComponent,
    UserAddComponent,
    UserListComponent,
    UserUpdateComponent,
  ],
  imports: [
    SharedModule,
    DashboardRoutingModule,
  ]
})
export class DashboardModule { }
