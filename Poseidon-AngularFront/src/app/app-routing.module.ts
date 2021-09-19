import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BidsViewComponent } from './bids-view/bids-view.component';
import { CurvePointsViewComponent } from './curve-points-view/curve-points-view.component';
import { RatingsViewComponent } from './ratings-view/ratings-view.component';
import { TradesViewComponent } from './trades-view/trades-view.component';
import { RulesViewComponent } from './rules-view/rules-view.component';
import { LoginViewComponent } from './login-view/login-view.component';
import { NotFoundComponent } from './not-found/not-found.component';

const routes: Routes = [
  {path: '', component: LoginViewComponent},
  {path: 'bids', component: BidsViewComponent},
  {path: 'curvePoints', component: CurvePointsViewComponent},
  {path: 'ratings', component: RatingsViewComponent},
  {path: 'trades', component: TradesViewComponent},
  {path: 'rules', component: RulesViewComponent},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
