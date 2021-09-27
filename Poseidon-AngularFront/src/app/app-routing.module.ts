import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthenticateGuard } from 'src/app/authenticate.guard';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  // todo cabler le guard, et créer un home ou dashboard module qui contiendra le routage vers les modules métiers
  { path: '', loadChildren: () => import('./dashboard/dashboard.module').then(m => m.DashboardModule), canActivate: [AuthenticateGuard] },
  { path: 'login', component: LoginComponent, pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
