import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
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

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatMenuModule} from '@angular/material/menu';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';

@NgModule({
  declarations: [
    AppComponent,
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
    LoginComponent,
    UserAddComponent,
    UserListComponent,
    UserUpdateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatMenuModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    FormsModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
