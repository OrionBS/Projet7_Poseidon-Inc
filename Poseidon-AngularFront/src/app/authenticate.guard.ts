import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { AuthenticateService } from "./login/authenticate.service";

@Injectable({
    providedIn: 'root',
})
export class  AuthenticateGuard implements CanActivate {
    constructor(private auth: AuthenticateService, private router: Router) {
    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        const isLogged = !!this.auth.getJwt();
        if (!isLogged) {
            this.router.navigate(['/login']);
            return false
        }
        return true;
    }

}